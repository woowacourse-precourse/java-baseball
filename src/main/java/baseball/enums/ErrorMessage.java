package baseball.enums;

public enum ErrorMessage {
    BLANK_INPUT("아무것도 입력하지 않았습니다."),
    NOT_THREE_LENGTH("세 자리가 아닙니다."),
    NOT_NUMBER_OR_CONTAINS_0("숫자가 아니거나 0이 포함되어 있습니다"),
    DUPLICATED("중복된 숫자가 포함되어 있습니다."),
    NOT_ONE_OR_TWO("1 또는 2를 입력해야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return errorMessage;
    }
}
