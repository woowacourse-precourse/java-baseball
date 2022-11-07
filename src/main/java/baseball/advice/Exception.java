package baseball.advice;

public class Exception {
    public static final String NUMERIC_ERROR_MESSAGE = "숫자가 아닙니다.";
    public static final String SIZE_ERROR_MESSAGE = "유효한 숫자 개수가 아닙니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";
    public static final String CONTAIN_ZERO_ERROR_MESSAGE = "숫자 0이 포함되어 있습니다.";
    public static final String RESTART_ERROR_MESSAGE = "유효한 숫자가 아닙니다.";

    public static void numericErrror() {
        throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
    }

    public static void sizeEroor() {
        throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
    }

    public static void duplicationError() {
        throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }

    public static void containZeroError() {
        throw new IllegalArgumentException(CONTAIN_ZERO_ERROR_MESSAGE);
    }

    public static void restartError() {
        throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
    }
}
