package baseball.message;

public enum ErrorMessage {
    // 유저의 숫자야구 추측 입력시
    NUMERIC_INPUT_EXCEPTION("1 ~ 9사이의 숫자만 입력해야 합니다."),
    NUMERIC_LENGTH_EXCEPTION("3글자의 숫자를 입력해야 합니다."),
    SAME_NUMBER_EXCEPTION("3개의 숫자는 모두 달라야 합니다.");

    // 유저의 새게임 여부 입력시


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
