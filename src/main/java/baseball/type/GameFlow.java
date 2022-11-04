package baseball.type;

public enum GameFlow {
    GAME_RESTART(1),
    GAME_END(2);

    private final int value;

    GameFlow(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
