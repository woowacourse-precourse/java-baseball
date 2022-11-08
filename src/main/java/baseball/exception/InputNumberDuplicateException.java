package baseball.exception;

public class InputNumberDuplicateException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값에 중복이 존재합니다.";

    public InputNumberDuplicateException() {
        super(MESSAGE);
    }
}
