package baseball;

public enum State {
    RESTART("1"),
    SHUTDOWN("2");

    private String number;

    State(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
