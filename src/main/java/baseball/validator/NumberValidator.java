package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;

    private final static int INPUT_DIGIT = 3;
    private final static String RANGE_ERROR_MESSAGE = "1부터 9 사이의 자연수를 입력해주세요.";
    private final static String DIGIT_ERROR_MESSAGE = "입력 길이는 3입니다.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";


    public static void validateRange(int input) {
        if (input < MIN_RANGE_NUM || input > MAX_RANGE_NUM) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
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

    public static void validateNonNumeric(int input) {
        String changeTypeString = String.valueOf(input);
        for (char charString : changeTypeString.toCharArray()) {
            if (charString >= 48 && charString <= 57) {
                continue;
            }
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }
}
