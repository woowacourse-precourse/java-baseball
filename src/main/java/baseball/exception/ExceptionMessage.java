package baseball.exception;

public enum ExceptionMessage {

    DUPLICATE_DIGIT_EXCEPTION("input can't have duplicate number."),
    INVALID_DIGIT_EXCEPTION("input must be three digits."),
    NEGATIVE_DIGIT_EXCEPTION("input must be positive digits."),
    INVALID_COMMAND_DIGIT_EXCEPTION("input must be 1 or 2.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
