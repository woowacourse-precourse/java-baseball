package baseball.enums.game;

public enum GuessTarget {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String value;

    GuessTarget(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
