package baseball.exception;

public class WrongNumberException extends  IllegalArgumentException{
    private static final String INVALID_BASEBALL_NUMBER_RANGE = "1 ~ 9 사이의 값을 입력해야 합니다.";

    public WrongNumberException() {
        super(INVALID_BASEBALL_NUMBER_RANGE);
    }
}
