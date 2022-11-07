package baseball.object;

public enum GameStatus {
    RESTART(1), END(2);

    private Integer value;

    GameStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
