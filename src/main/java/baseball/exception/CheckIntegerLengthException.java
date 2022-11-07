package baseball.exception;

public class CheckIntegerLengthException extends IllegalArgumentException {
    public CheckIntegerLengthException() {
        super("3자리의 수를 입력해주세요");
    }
}
