package baseball.controller;

public enum Rule {
    START_NUMBER(1),
    END_NUMBER(9),
    LENGTH(3);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
