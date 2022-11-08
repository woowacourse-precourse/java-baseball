package baseball.exception;

public class CantBlankOrNullInputException extends IllegalArgumentException{
    public CantBlankOrNullInputException() {
        super("null 이나 빈값이 들어올 수 없습니다.");
    }
}
