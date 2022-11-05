package baseball.validator;

public enum NumberStatus {
    NO_NUMBER("Only numbers can be entered."),
    NO_THREE_DIGIT("It's not a three-digit number."),
    NO_DUPLICATE_NUMBER("Duplicate numbers cannot be entered."),
    NO_CONTAIN_ZERO("zero cannot be selected."),
    WRONG_NUMBER("wrong number");

    private String message;

    NumberStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
