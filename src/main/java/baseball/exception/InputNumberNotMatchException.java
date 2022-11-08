package baseball.exception;

public class InputNumberNotMatchException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값이 3자리가 아닙니다.";

    public InputNumberNotMatchException() {
        super(MESSAGE);
    }
}
