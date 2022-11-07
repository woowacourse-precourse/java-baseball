package baseball;

public class Validator {

    public static void validateInteger(char character) {
        if (!Character.isDigit(character)) {
            throw new IllegalArgumentException();
        }
    }
}
