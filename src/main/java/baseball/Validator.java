package baseball;

public class Validator {
    private static final int NUMBER_LENGTH = 3;

    public static void validateInteger(char character) {
        if (!Character.isDigit(character)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
