package baseball.exception;

public class InputNumberFormatException extends IllegalNumberInputException {

    private static final String NUMBER_FORMAT_ERROR = "잘못된 숫자 입력입니다. 입력 문자: %s";

    public InputNumberFormatException(String str) {
        super(String.format(NUMBER_FORMAT_ERROR, str));
    }
}
