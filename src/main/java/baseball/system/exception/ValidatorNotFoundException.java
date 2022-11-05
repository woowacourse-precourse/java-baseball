package baseball.system.exception;

public class ValidatorNotFoundException extends RuntimeException {
    public ValidatorNotFoundException() {
        super();
    }

    public ValidatorNotFoundException(String message) {
        super(message);
    }

    public ValidatorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ValidatorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
