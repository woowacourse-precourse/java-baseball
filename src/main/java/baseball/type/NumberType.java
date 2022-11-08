package baseball.type;

public enum NumberType {
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(9),
    NUMBER_SIZE(3);

    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
