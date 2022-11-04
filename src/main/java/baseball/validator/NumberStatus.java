package baseball.validator;

public enum ErrorCode {
    NO_NUMBER("Only numbers can be entered."),
    NO_THREE_DIGIT("It's not a three-digit number."),
    NO_DUPLICATE_NUMBER("Duplicate numbers cannot be entered."),
    NO_CONTAIN_ZERO("zero cannot be selected.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
