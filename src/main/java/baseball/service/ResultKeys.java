package baseball.service;

public enum ResultKeys {

    STRIKE("strike"),
    BALL("ball");

    private final String key;

    ResultKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
