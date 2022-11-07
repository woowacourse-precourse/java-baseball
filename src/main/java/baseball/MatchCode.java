package baseball;

public enum MatchCode {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    END("3스트라이크");

    private final String result;

    MatchCode(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}