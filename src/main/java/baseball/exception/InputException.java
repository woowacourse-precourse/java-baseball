package baseball.exception;

public class InputException {

    private static final String NOT_INTEGER_INPUT = "정수를 입력해 주세요.";
    private static final String NOT_THREE_LENGTH_INTEGER_INPUT = "3자리의 정수를 입력해 주세요.";
    private static final String INCLUDE_ZERO_INPUT = "0이 포함되지 않아야 합니다.";
    private static final String DUPLICATE_NUMBER_INPUT = "중복되지 않는 수를 입력해 주세요.";

    public static void throwNotIntegerInputError() {
        throw new IllegalArgumentException(NOT_INTEGER_INPUT);
    }

    public static void throwNotThreeLengthIntegerInputError() {
        throw new IllegalArgumentException(NOT_THREE_LENGTH_INTEGER_INPUT);
    }

    public static void throwIncludeZeroInputError() {
        throw new IllegalArgumentException(INCLUDE_ZERO_INPUT);
    }

    public static void throwDuplicateNumberInputError() {
        throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT);
    }
}
