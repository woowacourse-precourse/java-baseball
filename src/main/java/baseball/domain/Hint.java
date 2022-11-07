package baseball.domain;

public enum Hint {
    STRIKE("스트라이크", 0),
    BALL("볼", 0);

    private String value;
    private int count;

    Hint() {}

    Hint(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public static void addCount(Hint hint) {
        hint.count++;
    }
}
