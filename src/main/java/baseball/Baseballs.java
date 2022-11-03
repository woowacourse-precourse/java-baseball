package baseball;

public class Baseballs {
    private static final int BASEBALL_COUNT = 3;
    private static char MIN_VALID_RANGE = '1';
    private static char MAX_VALID_RANGE = '9';

    public static Baseballs of(String userInput) {
        return new Baseballs(userInput);
    }

    private Baseballs(String userInput) {
        validate(userInput);
    }

    private void validate(String userInput) {
        isEmpty(userInput);
        isLengthEqualsBaseballCount(userInput);
        isConsistOfOnlyProperRangedInputs(userInput);
    }

    private void isConsistOfOnlyProperRangedInputs(String userInput) {
        for (Character characterInUserInput : userInput.toCharArray()) {
            isProperRangedInput(characterInUserInput);
        }
    }

    private void isProperRangedInput(Character characterInUserInput) {
        if (characterInUserInput < MIN_VALID_RANGE || characterInUserInput > MAX_VALID_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void isLengthEqualsBaseballCount(String userInput) {
        if (userInput.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void isEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
