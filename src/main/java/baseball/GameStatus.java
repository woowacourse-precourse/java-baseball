package baseball;

public class GameStatus {
    int status;

    public GameStatus(int status) {
        this.status = status;
    }

    public boolean isRestart() {
        return status == 1;
    }

    public boolean isValid() {
        return status == 1 || status == 2;
    }
}
