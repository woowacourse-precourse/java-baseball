package baseball.exception;

public class InputNotDigitException extends IllegalArgumentException {
    public InputNotDigitException() {
        super("숫자만 입력하시오.");
    }
}
