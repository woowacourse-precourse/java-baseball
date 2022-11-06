package baseball.engine;

import baseball.model.BallStatus;
import baseball.model.Numbers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DefaultBaseBallGameEngine implements BaseBallGameEngine {
    private final static int NUMBERS_SIZE = 3;

    private final NumberGenerator generator;

    public DefaultBaseBallGameEngine(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public BallStatus createBallStatus(Numbers answer, Numbers userNumbers) {
        if (answer == null || userNumbers == null) {
            throw new IllegalArgumentException();
        }

        AtomicInteger ball = new AtomicInteger();
        AtomicInteger strike = new AtomicInteger();

        countBallOrStrike(answer, userNumbers, ball, strike);

        return new BallStatus(ball.get(), strike.get());
    }

    private void countBallOrStrike(Numbers answer, Numbers userNumbers, AtomicInteger ball, AtomicInteger strike) {
        userNumbers.iterateForEach((i, n) -> {
            if (!answer.containAnswer(n)) {
                return;
            }

            if (answer.matchStrike(i, n)) {
                strike.getAndIncrement();
                return;
            }

            ball.getAndIncrement();
        });
    }

    @Override
    public Numbers parseToNumbers(String number) {
        if (number == null || isNotValidNumber(number)) {
            throw new IllegalArgumentException();
        }

        return new Numbers(number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private boolean isNotValidNumber(String stringNumber) {
        if (stringNumber.length() != NUMBERS_SIZE) {
            return true;
        }

        long count = stringNumber.chars()
                .filter(Character::isDigit)
                .count();

        return count != NUMBERS_SIZE;
    }

    @Override
    public Numbers generateAnswer() {
        return generator.generate(NUMBERS_SIZE);
    }

    @Override
    public boolean isNotCorrect(BallStatus ballStatus) {
        return ballStatus.getStrike() != NUMBERS_SIZE;
    }
}
