package baseball.exception;

public class InputNotThreeDigitException extends IllegalArgumentException {
    public InputNotThreeDigitException() {
        super("세자리로 입력하시오.");
    }
}
