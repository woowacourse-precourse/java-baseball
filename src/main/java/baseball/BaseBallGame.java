package baseball;

public class BaseBallGame {
    GameMessageDisplay gameMessageDisplay;

    public BaseBallGame() {
        this.gameMessageDisplay = new GameMessageDisplay();
    }

    public void startGame() {
        this.gameMessageDisplay.printGameStartMessage();
    }
}
