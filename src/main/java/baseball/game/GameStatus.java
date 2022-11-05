package baseball.game;

public enum GameStatus {
    PROGRESSING(1),
    EXIT(2);

    private final int select;

    GameStatus(int select) {
        this.select = select;
    }

    public boolean isProgressing() {
        return this == PROGRESSING;
    }
}
