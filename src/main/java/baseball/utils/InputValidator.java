package baseball.utils;

public class InputValidator {

    public final static Integer RESTART = 1;
    public final static Integer EXIT = 2;
    public final static Integer CHECK_PROGRESS_INPUT_LENGTH = 1;
    public final static Integer BASEBALL_INPUT_LENGTH = 3;

    public static void checkBaseballInput(String baseballInput) {
        checkNumbers(baseballInput);
        checkLength(baseballInput, BASEBALL_INPUT_LENGTH);
    }

    private static void checkLength(String input, Integer length) {
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumbers(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
