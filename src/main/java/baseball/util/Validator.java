package baseball.util;

public class Validator {
    public void validateIsDigit(Character number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumber(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException();
        }
    }
}
