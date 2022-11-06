package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidator {
    private final static int INPUT_DIGIT = 3;
    private final static String DIGIT_ERROR_MESSAGE = "입력 길이는 3입니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";

    public static void validateNonNumeric(String input) {
        String changeTypeString = String.valueOf(input);
        for (char charString : changeTypeString.toCharArray()) {
            if (charString >= 48 && charString <= 57) {
                continue;
            }
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateDigit(int input) {
        String changeInputType = Integer.toString(input);
        int inputLength = changeInputType.length();
        if (inputLength != INPUT_DIGIT) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
