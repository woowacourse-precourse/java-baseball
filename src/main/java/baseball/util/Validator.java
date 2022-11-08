package baseball.util;

public class Validator {
    public void validateIsDigit(Character number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException();
        }
    }
}
