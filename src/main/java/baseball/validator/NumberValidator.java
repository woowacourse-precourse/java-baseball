package baseball.validator;

public class NumberValidator {

    public static void validate(String userNumber) {
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }

        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
