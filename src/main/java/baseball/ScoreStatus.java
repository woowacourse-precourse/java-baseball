package baseball;

public enum ScoreStatus {

    NOTHING("낫싱"),
    BALL("볼 "),
    STRIKE("스트라이크");

    private final String message;

    ScoreStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}