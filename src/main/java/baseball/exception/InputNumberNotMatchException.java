package baseball.exception;

public class InputNumberNotMatchException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값의 자릿수가 일치하지 않습니다.";

    public InputNumberNotMatchException() {
        super(MESSAGE);
    }
}
