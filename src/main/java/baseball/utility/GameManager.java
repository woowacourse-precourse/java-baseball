package baseball.utility;

import baseball.constant.GameStatus;

public class GameManager {
    private static GameManager gameManager;

    private GameStatus gameStatus;
    private String computerNumber;

    private GameManager() {
        this.gameStatus = GameStatus.STOPPED;
    }
}
