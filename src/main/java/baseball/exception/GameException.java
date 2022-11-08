package baseball.exception;

public class GameException extends IllegalArgumentException{
    private ExceptionCode exceptionCode;
    public GameException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
