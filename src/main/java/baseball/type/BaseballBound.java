package baseball.type;

public enum BaseballBound {
    BASEBALL_MAX_SIZE(3),
    BASEBALL_NUMBER_MIN(1),
    BASEBALL_NUMBER_MAX(9);

    private final int value;

    BaseballBound(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
