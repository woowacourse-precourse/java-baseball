package baseball.exception;

public class GameExceptionHandler {

    public static void handleNotNumberException(String input) throws IllegalArgumentException {
        if (input.matches("[1-9]+") == false) {
            throw new IllegalArgumentException("Input is not number.");
        }
    }

    public static void handleEmptyException(String input) throws IllegalArgumentException {
        if (input.isEmpty() == true) {
            throw new IllegalArgumentException("Input is empty.");
        }
    }

    public static void handleNotThreeNumbersException(String input)
            throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("Input number length is not 3.");
        }
    }

    public static void handleIncludeZeroException(String input) throws IllegalArgumentException {
        if (input.contains("0")) {
            throw new IllegalArgumentException("Input number contains 0.");
        }
    }

    public static void handleRestartInputException(String input) throws IllegalArgumentException {
        if (input.matches("^[1-2]$") == false) {
            throw new IllegalArgumentException("Input number is not 1 or 2.");
        }
    }

    public static void handleCommonException(String input) throws IllegalArgumentException {
        handleEmptyException(input);
        handleNotNumberException(input);
    }

    public static void handleInGameException(String input) throws IllegalArgumentException {
        handleCommonException(input);

        handleNotThreeNumbersException(input);
        handleIncludeZeroException(input);
    }

    public static void handleAfterGameOverException(String input) throws IllegalArgumentException {
        handleCommonException(input);

        handleRestartInputException(input);
    }
}
