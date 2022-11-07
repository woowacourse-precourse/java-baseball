package baseball.mvc.util;

public class ApplicationRuntimeException extends RuntimeException {

    private final static String DEFAULT_EXCEPTION_MESSAGE = "애플리케이션에 문제가 발생했습니다.";

    public ApplicationRuntimeException(Throwable cause) {
        super(DEFAULT_EXCEPTION_MESSAGE, cause);
    }
}
