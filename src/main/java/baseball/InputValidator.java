package baseball;

public class InputValidator {
    private static final String NON_NUMERIC_VALUE_EXCEPTION_MESSAGE = "숫자가 아닌 값을 입력하였습니다.";

    public static void validateNumber(String inputValue) {
        checkNonNumericValue(inputValue);
    }

    private static void checkNonNumericValue(String inputValue) {
        if (!isNumber(inputValue)) {
            throw new IllegalArgumentException(NON_NUMERIC_VALUE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }
}
