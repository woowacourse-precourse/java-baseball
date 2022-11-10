package baseball.util;

public enum CompareResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    THREE_STRIKE("3스트라이크");

    private String value;

    CompareResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
