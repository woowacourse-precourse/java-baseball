package baseball.enums;

public enum ErrorMessage {
    OVER_SIZE("야구게임 값이 3자리 수를 초과했습니다."),
    INVALID_SIZE("야구게임 값은 3자리 수여야 합니다."),
    INVALID_DIGIT("야구게임 값의 각 자릿수는 1 ~ 9사이여야 합니다."),
    DUPLICATE_DIGIT("야구 게임의 값의 각 자릿수는 서로 달라야 합니다."),
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_NUMBER("입력된 값이 숫자가 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String value() {
        return this.message;
    }
}
