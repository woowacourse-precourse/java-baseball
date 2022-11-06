package baseball.validator;

public class NumberValidator {
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static String RANGE_ERROR_MESSAGE = "1부터 9 사이의 자연수를 입력해주세요.";

    public static void validateRange(int input) {
        if (input < MIN_RANGE_NUM || input > MAX_RANGE_NUM) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
