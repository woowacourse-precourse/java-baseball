package baseball;

public enum GameStatus {
    ON(1),
    EXIT(2);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }
}
