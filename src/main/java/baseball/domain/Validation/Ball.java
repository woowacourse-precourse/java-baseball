package baseball.domain.Validation;

public enum Ball {
    MIN(1),
    MAX(9),
    COUNT(3);

    private final int value;

    Ball(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
