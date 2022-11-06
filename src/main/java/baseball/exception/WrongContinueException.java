package baseball.exception;

public class WrongContinueException extends IllegalArgumentException{
    private static final String INVALID_CONTINUE_MESSAGE_FORMAT = "1 또는 2를 입력해야 합니다.";

    public WrongContinueException() {
        super(INVALID_CONTINUE_MESSAGE_FORMAT);
    }
}
