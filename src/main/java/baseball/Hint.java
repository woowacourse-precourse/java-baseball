package baseball;

public enum Hint {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private String value;

    Hint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
