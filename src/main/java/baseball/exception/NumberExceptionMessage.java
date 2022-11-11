package baseball.exception;

public enum NumberExceptionMessage {

    INPUT_DUPLICATE_DIGIT_EXCEPTION("input can't have duplicate number."),
    INPUT_INVALID_DIGIT_LENGTH_EXCEPTION("input must be three digits."),
    INPUT_INVALID_DIGIT_EXCEPTION("input must not be negative digits or contain character."),
    INPUT_COMMAND_DIGIT_EXCEPTION("input must be 1 or 2.");

    private final String message;

    NumberExceptionMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
