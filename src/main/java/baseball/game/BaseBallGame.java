package baseball.game;

import baseball.io.Input;
import baseball.io.Message;
import baseball.io.Output;
import baseball.game.model.BallCount;
import baseball.game.generator.NumberGenerator;
import baseball.game.model.TargetNumber;

import java.util.Optional;
import java.util.stream.Collectors;

public class BaseBallGame implements Runnable {

    private static final int COUNT_OF_NUMBERS = 3;
    private final NumberGenerator generator;
    private final Input input;
    private final Output output;


    public BaseBallGame(NumberGenerator generator, Input input, Output output) {
        this.generator = generator;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        TargetNumber targetNumber = generator.createTargetNumber(COUNT_OF_NUMBERS);
        Flag flag = Flag.CONTINUE;
        output.print(Message.START);

        while (flag.isAgain()) {
            output.print(Message.INPUT);
            String inputString = input.scan();

            Optional<TargetNumber> inputNumber = validateNumber(inputString);

            if (inputNumber.isEmpty()) {
                throw new IllegalArgumentException();
            }

            BallCount ballCount = new BallCount(targetNumber, inputNumber.get());
            output.printBallCount(ballCount);

            if (ballCount.isCorrect(COUNT_OF_NUMBERS)) {
                output.printEndMessage(COUNT_OF_NUMBERS);
                output.print(Message.END);
                output.print(Message.RESTART);

                String inputFlag = input.scan();
                flag = Flag.findByNumber(inputFlag);

                targetNumber = regenerate(targetNumber, flag);
            }
        }
        output.print(Message.END);
    }

    private TargetNumber regenerate(TargetNumber targetNumber, Flag flag) {
        if (flag.isAgain()) {
            targetNumber = generator.createTargetNumber(COUNT_OF_NUMBERS);
        }
        return targetNumber;
    }

    private Optional<TargetNumber> validateNumber(String input) {

        long count = input.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .filter(i -> i > 0)
                .distinct()
                .count();

        if (count != COUNT_OF_NUMBERS) {
            return Optional.empty();
        }

        return Optional.of(
                new TargetNumber(input.chars()
                        .map(Character::getNumericValue)
                        .boxed()
                        .collect(Collectors.toList())
        ));
    }
}
