package baseball;

public enum ThrowingType {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String text;

    ThrowingType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
