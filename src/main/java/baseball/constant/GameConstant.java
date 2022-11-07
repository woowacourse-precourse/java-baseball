package baseball.constant;

public enum GameConstant {

    START(1),
    END(2),
    DIGIT(3),
    MIN(1),
    MAX(9);

    private final int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
