package baseball.domain;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String symbol;

    Hint(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
