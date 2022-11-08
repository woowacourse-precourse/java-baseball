package baseball.message;

public enum SystemMessage implements Message {
    START_PROGRAM("숫자 야구 게임을 시작합니다."),
    STOP_PROGRAM("게임 종료");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

