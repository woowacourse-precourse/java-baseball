package baseball.utils;

import static baseball.utils.BaseBallStatus.BASEBALL_DEFAULT_SIZE;

public enum ErrorMessage {
    INVALID_STRIKE_NUMBER("스트라이크의 범위는 0 ~ 3 입니다."),
    INVALID_BALL_NUMBER("볼의 범위는 0 ~ 3 입니다."),
    INVALID_BASEBALL_SIZE("숫자야구의 자리수는 " + BASEBALL_DEFAULT_SIZE.getCode() + "자리 입니다."),
    INVALID_ARGUMENT("잘못된 값입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
