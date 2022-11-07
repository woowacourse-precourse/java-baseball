package baseball.exception;

public class InputException {

    private static final String NOT_INTEGER_INPUT = "정수를 입력해 주세요.";
    private static final String NOT_THREE_LENGTH_INTEGER_INPUT = "3자리의 정수를 입력해 주세요.";

    public static void throwNotIntegerInputError() {
        throw new IllegalArgumentException(NOT_INTEGER_INPUT);
    }

    public static void throwNotThreeLengthIntegerInputError() {
        throw new IllegalArgumentException(NOT_THREE_LENGTH_INTEGER_INPUT);
    }
}
