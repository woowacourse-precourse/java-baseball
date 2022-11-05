package baseball;

public enum State {
    RESTART("1"),
    SHUTDOWN("2");

    private final String stateNumber;

    State(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getNumber() {
        return stateNumber;
    }
}
