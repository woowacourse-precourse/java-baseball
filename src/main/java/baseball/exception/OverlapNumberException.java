package baseball.exception;

public class OverlapNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "중복된 입력이 있습니다.";

    public OverlapNumberException() {
        super(MESSAGE);
    }
}
