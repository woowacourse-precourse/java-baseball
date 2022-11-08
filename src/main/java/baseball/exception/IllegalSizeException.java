package baseball.exception;

public class IllegalSizeException extends IllegalStateException{

    public final static IllegalSizeException EXCEPTION = new IllegalSizeException();

    private IllegalSizeException() {
        super("입력값 갯수가 올바르지 않습니다!");
    }
}
