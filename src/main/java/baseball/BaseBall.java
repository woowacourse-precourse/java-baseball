package baseball;

import baseball.io.Input;
import baseball.io.Output;
import baseball.model.BallCount;
import baseball.model.Numbers;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseBall {
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 9;
    private static final int COUNT_OF_NUMBERS = 3;

    private NumberGenerator numberGenerator;
    private Input input;
    private Output output;

    public BaseBall(NumberGenerator numberGenerator, Input input, Output output) {
        this.numberGenerator = numberGenerator;
        this.input = input;
        this.output = output;
    }

    public void play() throws IllegalArgumentException {
        Numbers computerNumbers = numberGenerator.generateUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE, COUNT_OF_NUMBERS);

        while (true) {
            Optional<Numbers> playerNumbers = getPlayerNumbers();
            if (playerNumbers.isEmpty()) {
                throw new IllegalArgumentException();
            }

            BallCount bc = ballCount(computerNumbers, playerNumbers.get());
            output.ballCount(bc);

            if (bc.getStrike() == COUNT_OF_NUMBERS) {
                output.correct();
                break;
            }
        }
    }

    private Optional<Numbers> getPlayerNumbers() {
        String inputString = this.input.input("숫자를 입력해주세요 : ");
        if (inputString.length() != COUNT_OF_NUMBERS) return Optional.empty();

        long count = inputString.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .filter(number -> number > 0)
                .distinct()
                .count();
        if (count != COUNT_OF_NUMBERS) return Optional.empty();

        Integer[] playerNumbers = inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toArray(Integer[]::new);

        return Optional.of(
                new Numbers(playerNumbers)
        );
    }

    private BallCount ballCount(Numbers computerNumbers, Numbers playerNumbers) {
        AtomicInteger strike = new AtomicInteger();
        AtomicInteger ball = new AtomicInteger();

        computerNumbers.indexedForEach((computerNumber, i) -> {
            playerNumbers.indexedForEach((playerNumber, j) -> {
                if (!computerNumber.equals(playerNumber)) return;
                if (i.equals(j)) strike.addAndGet(1);
                else ball.addAndGet(1);
            });
        });
        return new BallCount(strike.get(), ball.get());
    }
}
