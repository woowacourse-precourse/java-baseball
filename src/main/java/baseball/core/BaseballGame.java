package baseball.core;

public class BaseballGame {

    private String targetNumber;
    private GameStatus currentStatus;

    public BaseballGame(String targetNumber, GameStatus currentStatus) {
        this.targetNumber = targetNumber;
        this.currentStatus = currentStatus;
    }

    public void checkSuccessOrFail() {

    }

    //== Getter & Setter ==//
    public String getTargetNumber() {
        return targetNumber;
    }
    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }
    public GameStatus getCurrentStatus() {
        return currentStatus;
    }
    public void setCurrentStatus(GameStatus currentStatus) {
        this.currentStatus = currentStatus;
    }
}
