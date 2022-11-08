package baseball;

public enum GameStatus {
    STRIKE_OUT(3), EXIT(2), RESTART(1), MAX_SIZE(3);

    private final int value;
    GameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
