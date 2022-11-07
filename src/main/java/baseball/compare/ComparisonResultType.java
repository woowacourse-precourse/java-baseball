package baseball.compare;

public enum ComparisonResultType {
    STRIKE("스트라이크"),
    BALL("볼");

    private final String value;

    ComparisonResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
