package baseball.exception;

public enum ExceptionMessage {

    DUPLICATE_DIGIT_EXCEPTION("input can't have duplicate number."),
    INVALID_DIGIT_EXCEPTION("input must be three digits."),
    NEGATIVE_DIGIT_EXCEPTION("input must be positive digits."),
    INVALID_CHARACTER_EXCEPTION("input must not be character or special character."),
    INVALID_COMMAND_DIGIT_EXCEPTION("input must be 1 or 2.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
