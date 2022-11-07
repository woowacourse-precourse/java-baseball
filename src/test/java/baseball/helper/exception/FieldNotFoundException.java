package baseball.helper.exception;

public class FieldNotFoundException extends RuntimeException {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "필드를 찾지 못했습니다.";

    public FieldNotFoundException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }
}
