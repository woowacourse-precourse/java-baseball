package baseball.utils;

public class InputValidation {

    private static final String NON_DIGIT_ERR_MESSAGE
        = "숫자만 입력가능합니다.";

    public static void validateIsAllDigit(final String input) {
        if (!isAllDigits(input)) {
            throw new IllegalArgumentException(NON_DIGIT_ERR_MESSAGE);
        }
    }

    private static boolean isAllDigits(final String input) {
        return input.chars()
            .allMatch(Character::isDigit);
    }
}
