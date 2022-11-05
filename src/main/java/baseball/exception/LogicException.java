package baseball.exception;

public class LogicException extends IllegalArgumentException{

    public final ExceptionCode exceptionCode;

    public LogicException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
