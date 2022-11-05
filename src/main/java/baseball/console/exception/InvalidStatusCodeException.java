package baseball.console.exception;

public class InvalidStatusCodeException extends IllegalNumberInputException {

    private static final String INVALID_STATUS_NUMBER = "0 또는 1을 입력해주세요. 입력 문자: %s";

    public InvalidStatusCodeException(String str) {
        super(String.format(INVALID_STATUS_NUMBER, str));
    }
}
