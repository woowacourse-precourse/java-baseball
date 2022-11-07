package baseball.domain;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String value;

    Hint() {}

    Hint(String value) {
        this.value = value;
    }
}
