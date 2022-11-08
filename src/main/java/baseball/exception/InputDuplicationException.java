package baseball.exception;

public class InputDuplicationException extends IllegalArgumentException{

    public final static InputDuplicationException EXCEPTION = new InputDuplicationException();

    private InputDuplicationException() {
        super("입력값에 중복된 값이 있습니다!");
    }
}
