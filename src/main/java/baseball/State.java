package baseball;

public enum State {
    BALL("볼"),
    NOTHING("낫싱"),
    STRIKE("스트라이크");

    final String output;

    State(String output) {
        this.output = output;
    }
}
