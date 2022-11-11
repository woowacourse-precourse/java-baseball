package baseball.exception;

public enum NumberExceptionMessage {

    INPUT_DUPLICATE_DIGIT_EXCEPTION("input can't have duplicate number."),
    INPUT_INVALID_DIGIT_EXCEPTION("input must be three digits."),
    INPUT_NEGATIVE_DIGIT_EXCEPTION("input must be positive digits."),
    INPUT_INVALID_CHARACTER_EXCEPTION("input must not be character or special character."),
    INPUT_COMMAND_DIGIT_EXCEPTION("input must be 1 or 2.");

    private final String message;

    NumberExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
