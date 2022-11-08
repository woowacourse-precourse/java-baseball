package baseball.exception;

public class InputDuplicationNumberException extends IllegalArgumentException{
    public InputDuplicationNumberException() {
        super("숫자를 중복없이 입력하시오.");
    }
}
