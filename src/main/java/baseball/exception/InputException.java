package baseball.exception;

public class InputException {

    private static final String NOT_INTEGER_INPUT = "정수를 입력해 주세요.";

    public static void throwNotIntegerInputError() {
        throw new IllegalArgumentException(NOT_INTEGER_INPUT);
    }
}
