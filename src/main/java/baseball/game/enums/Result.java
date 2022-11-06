package baseball.game.enums;

public enum Result {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
