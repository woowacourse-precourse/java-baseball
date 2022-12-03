package baseball.util;

public enum InputExceptionPharse {
    IS_NULL("아무것도 입력하지 않았습니다."),
    NOT_BALL_SIZE("야구 공은 3개만 받을 수 있습니다."),
    NOT_PLAY_STATUS_SIZE("게임 상태는 1과 2 한 자리 입니다."),
    NOT_PLAY_NUMBER("1과 2만 입력 가능합니다."),
    NOT_NUMBER("사용자의 입력에 숫자가 아닌 값이 존재합니다.");

    private final String exceptionMsg;

    InputExceptionPharse(String msg) {
        this.exceptionMsg = msg;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }
}
