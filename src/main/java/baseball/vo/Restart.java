package baseball.vo;

public enum Restart {
    RESTART("1"),
    EXIT("2");

    private final String value;

    Restart(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
