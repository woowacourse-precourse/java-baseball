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
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (userInput.length() != BASEBALL_COUNT) {
            throw new IllegalArgumentException();
        }
        for (Character characterInUserInput : userInput.toCharArray()) {
            if (characterInUserInput < MIN_VALID_RANGE || characterInUserInput > MAX_VALID_RANGE) {
                throw new IllegalArgumentException();
            }
        }
    }
}
