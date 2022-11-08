package baseball.domain.game;

public enum GameStatus {
    START(1), END(2);

    private int status;

    public boolean isStart(){
        return this.equals(START);
    }

    GameStatus(int status) {
        this.status = status;
    }
}
