package baseball.exception;

public class InputNotMatchDigitException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값이 올바른 자릿 수가 아닙니다.";

    public InputNotMatchDigitException() {
        super(MESSAGE);
    }
}
