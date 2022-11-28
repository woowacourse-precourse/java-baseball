package baseball.validator;

import java.util.Arrays;

public class NumbersValidator {
    private final static int INPUT_DIGIT = 3;
    private final static String INVALID_DIGIT_ERROR_MESSAGE = "입력 길이는 3입니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateDigit(String input) {
        if (input.length() != INPUT_DIGIT) {
            throw new IllegalArgumentException(INVALID_DIGIT_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateNumber(String input) {
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
