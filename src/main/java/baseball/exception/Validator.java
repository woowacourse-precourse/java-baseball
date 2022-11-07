package baseball.exception;

public class Validator {
    public void validateInputNumbers(String input) {
        if (!(isLengthThree(input) && isElementsAreNumber(input))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    private boolean isElementsAreNumber(String input) {
        return isNumber(input.charAt(0)) && isNumber(input.charAt(1)) && isNumber(input.charAt(2));
    }

    private boolean isNumber(char element) {
        return '1' <= element && element <= '9';
    }

    public void validateInputRetry(String retry) {
        if (!(retry.equals("1") || retry.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
