package baseball.type;

public enum HintType {
    STRIKE_ZERO(0),
    BALL_ZERO(0);

    private final int value;

    HintType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
