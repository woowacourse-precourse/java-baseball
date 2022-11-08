package baseball.constants;

public enum ComparingResults {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String result;

    ComparingResults(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
