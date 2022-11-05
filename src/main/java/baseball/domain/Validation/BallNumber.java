package baseball.domain.Validation;

public enum BallNumber {
    NUMBER_MIN(1),
    NUMBER_MAX(9),
    NUMBER_LENGTH(3);

    private final int value;

    BallNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
