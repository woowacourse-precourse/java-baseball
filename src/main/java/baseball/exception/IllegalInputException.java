package baseball.exception;

public class IllegalInputException extends IllegalArgumentException {

    public final static IllegalInputException EXCEPTION = new IllegalInputException();

    private IllegalInputException() {
        super("존재하지 않는 선택지 입니다!");
    }
}
