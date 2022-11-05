package baseball.message;

public enum Message {
    STOP_PROGRAM("게임 종료"),
    BALL_PLACEHOLDER("볼"),
    STRIKE_PLACEHOLDER("스트라이크"),
    NOTHING_PLACEHOLDER("낫싱");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
