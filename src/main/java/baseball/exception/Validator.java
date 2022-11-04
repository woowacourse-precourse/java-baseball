package baseball.exception;

public class Validator {
    public void validateInput(String input) {
        if (!(isLengthThree(input) && isElementsAreNumber(input))) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    private boolean isElementsAreNumber(String input) {
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        return isNumber(first) && isNumber(second) && isNumber(third);
    }

    private boolean isNumber(char element) {
        return '1' <= element && element <= '9';
    }
}
