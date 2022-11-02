package baseball.validator;

public class NumberValidator {

    public static void validate(String userNumber) {
        if (!userNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}
