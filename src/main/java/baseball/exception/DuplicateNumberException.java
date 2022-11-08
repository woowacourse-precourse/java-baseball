package baseball.exception;

public class DuplicateNumberException extends BaseballException {

    private static final String DUPLICATE_NUMBER_ERROR = "서로 다른 숫자를 입력해주세요. 입력 문자: %s";

    public DuplicateNumberException(String str) {
        super(String.format(DUPLICATE_NUMBER_ERROR, str));
    }
}
