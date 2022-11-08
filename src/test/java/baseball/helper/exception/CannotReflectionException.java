package baseball.helper.exception;

public class CannotReflectionException extends RuntimeException {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "리플렉션에 실패했습니다.";

    public CannotReflectionException(Throwable cause) {
        super(DEFAULT_EXCEPTION_MESSAGE, cause);
    }
}
