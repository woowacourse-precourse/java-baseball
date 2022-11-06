package baseball.exception;

public class CheckContinueMessageException extends IllegalArgumentException {
    public CheckContinueMessageException() {
        super("1 또는 2를 입력해주세요");
    }
}
