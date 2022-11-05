package baseball.exception;

public class NotSuitableRegexException extends IllegalArgumentException {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public NotSuitableRegexException() {
        super(MESSAGE);
    }
}
