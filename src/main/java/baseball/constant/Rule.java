package baseball.constant;

public enum Rule {
    START(1),
    END(9),
    PICK(3);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
