package baseball.exception;

public class GameException extends RuntimeException{
    private ExceptionCode exceptionCode;

    public GameException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
