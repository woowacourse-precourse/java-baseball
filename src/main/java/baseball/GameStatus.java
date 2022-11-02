package baseball;

public enum GameStatus {

    START(1),
    END(2);

    private final int status;

    GameStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
