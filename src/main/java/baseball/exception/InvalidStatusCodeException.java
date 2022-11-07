package baseball.exception;

public class InvalidStatusCodeException extends BaseballException {

    private static final String INVALID_STATUS_NUMBER = "1 또는 2을 입력해주세요. 입력 문자: %s";

    public InvalidStatusCodeException(String str) {
        super(String.format(INVALID_STATUS_NUMBER, str));
    }
}
