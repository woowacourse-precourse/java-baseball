package baseball.exception;

public enum ExceptionMessage {

    DUPLICATE_DIGIT_EXCEPTION("input can't have duplicate number."),
    INVALID_DIGIT_EXCEPTION("input must be three digits."),
    NEGATIVE_DIGIT_EXCEPTION("input must be positive digits.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
