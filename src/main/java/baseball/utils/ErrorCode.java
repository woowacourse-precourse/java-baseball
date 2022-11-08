package baseball.utils;

public enum ErrorCode {
    NOT_NUMERIC_ONLY("숫자만 입력 가능합니다."),
    INVALID_LENGTH("입력받은 수가 3자리 수가 아닙니다."),
    INVALID_RANGE("각 자리의 수의 가능한 범위는 1~9 입니다."),
    DUPLICATE_NUMBER("중복되는 숫자가 존재합니다."),
    INVALID_RESTART_INPUT("적절하지 않은 입력 형식입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
