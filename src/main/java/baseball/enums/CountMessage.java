package baseball.enums;

public enum CountMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    SPACE(" "),
    NOTHING("낫싱");

    private String message;

    CountMessage(String message) {
        this.message = message;
    }

    public String value() {
        return this.message;
    }
}
