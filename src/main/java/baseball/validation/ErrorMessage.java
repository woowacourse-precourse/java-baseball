package baseball.validation;

public enum ErrorMessage {
    IS_BLANK("아무것도 입력하지 않았습니다."),
    IS_NOT_THREE_LENGTH("세 자리가 아닙니다."),
    IS_NOT_NUMBER_OR_CONTAINS_0("숫자가 아니거나 0이 포함되어 있습니다"),
    IS_DUPLICATE("중복된 숫자가 포함되어 있습니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return errorMessage;
    }
}
