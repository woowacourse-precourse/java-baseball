package baseball.exception;

public class InputNumberNotIntegerException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값이 숫자가 아닙니다.";

    public InputNumberNotIntegerException() {
        super(MESSAGE);
    }
}
