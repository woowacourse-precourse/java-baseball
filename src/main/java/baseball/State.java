package baseball;

public enum State {
    BALL("볼"),
    NOTHING("낫싱"),
    STRIKE("스트라이크");

    private final String output;

    State(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return output;
    }
}
