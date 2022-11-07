package baseball.status;

public enum ExceptionStatus {

    NOT_GAME_NUMBER("입력값이 1 또는 2가 아닙니다."),
    NOT_CORRECT_LENGTH("입력하신 수는 세자리가 아닙니다."),
    ZERO_IN_NUMBER("입력하신 수에 0이 포함됩니다."),
    IS_NOT_NUMBER("입력하신 수가 자연수로 이루어져있지 않습니다."),
    IS_OVERLAP("입력하신 수에 중복된 수가 존재함니다.");


    private final String message;

    ExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
