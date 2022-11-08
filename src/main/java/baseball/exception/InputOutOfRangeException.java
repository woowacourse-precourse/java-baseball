package baseball.exception;

public class InputOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값의 범위가 유효하지 않습니다.";

    public InputOutOfRangeException() {
        super(MESSAGE);
    }
}
