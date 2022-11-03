package baseball.constant;

public enum WarningMessage {
    IllegalInputWarningMessage("잘못된 값을 입력했습니다"),
    IllegalValueWarningMessage("타당하지 않은 값입니다"),
    DuplicateValueWarningMessage("중복된 값이 존재합니다");

    private final String message;

    WarningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
