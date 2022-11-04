package baseball.engine;

import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;
import baseball.model.Numbers;
import java.util.stream.Collectors;

public class BaseBallGame implements Runnable {
    private static final int NUMBERS_SIZE = 3;

    private final ConsoleOutput output;
    private final ConsoleInput input;

    public BaseBallGame(ConsoleOutput output, ConsoleInput input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void run() {
        output.printStartText();
    }

    private Numbers parseToNumbers(String stringNumber) {
        validateStringNumber(stringNumber);

        return new Numbers(stringNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private void validateStringNumber(String stringNumber) {
        if (stringNumber.length() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }

        long count = stringNumber.chars()
                .filter(Character::isDigit)
                .count();

        if (count != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
