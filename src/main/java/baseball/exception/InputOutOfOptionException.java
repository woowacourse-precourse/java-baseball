package baseball.exception;

public class InputOutOfOptionException extends IllegalArgumentException {
    private static final String MESSAGE = "옵션 값이 유효하지 않습니다.";

    public InputOutOfOptionException() {
        super(MESSAGE);
    }
}
