package baseball;

public enum Flag {
    RESTART("1");

    private final String value;

    Flag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
