package baseball.exception;

public class InputDuplicateException extends IllegalArgumentException {
    private static final String MESSAGE = "중복된 숫자가 존재합니다.";

    public InputDuplicateException() {
        super(MESSAGE);
    }
}
