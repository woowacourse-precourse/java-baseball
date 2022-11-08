package baseball.exception;

public class InputNotDigitOrZeroException extends IllegalArgumentException {
    public InputNotDigitOrZeroException() {
        super("0을 제외한 숫자만 입력하시오.");
    }
}
