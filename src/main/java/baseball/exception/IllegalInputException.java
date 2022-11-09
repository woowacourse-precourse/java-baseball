package baseball.exception;

public class IllegalInputException extends IllegalArgumentException {

    public final static IllegalInputException EXCEPTION = new IllegalInputException();

    private IllegalInputException() {
        super("입력값이 올바르지 않습니다!");
    }
}
