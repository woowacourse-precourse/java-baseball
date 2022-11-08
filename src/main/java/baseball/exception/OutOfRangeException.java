package baseball.exception;

public class OutOfRangeException extends RuntimeException {
    public static final OutOfRangeException EXCEPTION = new OutOfRangeException();

    private OutOfRangeException() {
        super("입력값이 범위를 초과했습니다.");
    }
}
