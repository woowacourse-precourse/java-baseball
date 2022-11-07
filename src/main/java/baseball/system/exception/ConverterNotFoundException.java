package baseball.system.exception;

public class ConverterNotFoundException extends RuntimeException {
    public ConverterNotFoundException() {
        super();
    }

    public ConverterNotFoundException(String message) {
        super(message);
    }

    public ConverterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConverterNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ConverterNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
