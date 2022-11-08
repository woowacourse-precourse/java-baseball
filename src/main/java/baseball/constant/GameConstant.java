package baseball.constant;

public enum GameConstant {
    VALID_NUMBER_LENGTH(3);

    private final int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
