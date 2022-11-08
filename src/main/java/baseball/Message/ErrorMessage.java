package baseball.Message;

public enum ErrorMessage {
    OUT_OF_LENGTH("3자리의 숫자만 입력할 수 있습니다."),
    DUPLICATED_NUMBERS("숫자는 중복될 수 없습니다."),
    BLANK_EXISTS("공백은 포함될 수 없습니다."),
    NOT_ALLOWED_CHARACTER("숫자만 입력할 수 있습니다."),
    ZERO_EXISTS("1부터 9까지 입력할 수 있습니다.");

    private String message;

    private ErrorMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
