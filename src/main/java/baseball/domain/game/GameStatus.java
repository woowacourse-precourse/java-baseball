package baseball.domain.game;

public enum GameStatus {
    START(1), END(2);

    private int status;

    GameStatus(int status) {
        this.status = status;
    }
}
