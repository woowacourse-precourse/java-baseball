package game;

public class GameStatus {
    private boolean isStart;
    private boolean isFinish;

    public GameStatus() {
        isStart = false;
        isFinish = false;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
