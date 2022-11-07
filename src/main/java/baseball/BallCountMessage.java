package baseball;

public enum BallCountMessage {
    STRIKE_KO("스트라이크"),
    BALL_KO("볼"),
    NOTHING_KO("낫싱");

    private final String message;

    BallCountMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
