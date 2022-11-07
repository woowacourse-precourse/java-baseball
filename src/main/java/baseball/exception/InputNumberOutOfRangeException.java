package baseball.exception;

public class InputNumberOutOfRangeException extends BaseballException {

    private static final String NUMBER_OUT_OF_RANGE_ERROR = "123~789 사이의 숫자를 입력해주세요. 입력 문자: %s";

    public InputNumberOutOfRangeException(String str) {
        super(String.format(NUMBER_OUT_OF_RANGE_ERROR, str));
    }
}
