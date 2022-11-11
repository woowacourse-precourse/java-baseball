package baseball;

public enum Hint {

    BALL("%d볼"),
    BALL_AND_STRIKE("%d볼 %d스트라이크"),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String value;

    Hint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
