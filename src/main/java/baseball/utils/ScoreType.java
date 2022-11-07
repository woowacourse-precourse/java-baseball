package baseball.utils;

public enum ScoreType {
    STRIKE("strike", "스트라이크"),
    BALL("ball", "볼"),
    NOTHING("nothing", "낫싱");

    private final String label;
    private final String value;

    ScoreType(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
