package baseball.domain;

public class BaseballGameException extends RuntimeException {
    private static final String MESSAGE = "야구 게임 오류 발생";

    public BaseballGameException() {
        super(MESSAGE);
    }
}
