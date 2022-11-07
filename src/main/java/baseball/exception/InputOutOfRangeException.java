package baseball.exception;

public class InputOutOfRangeException extends IllegalArgumentException {

    private static final String message = "유효한 범위의 입력 값이 아닙니다.";

    public InputOutOfRangeException() {
        super(message);
    }
}