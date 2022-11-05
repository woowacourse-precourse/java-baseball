package baseball.exception;

public class IllegalNumberInputException extends RuntimeException {

    private static final String ILLEGAL_NUMBER_ERROR = "잘못된 숫자 입력입니다. 입력 문자: %s";

    public IllegalNumberInputException(String str) {
        super(String.format(ILLEGAL_NUMBER_ERROR, str));
    }
}
