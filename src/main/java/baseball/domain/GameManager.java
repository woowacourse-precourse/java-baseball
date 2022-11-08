package baseball.domain;

import baseball.type.GameFlow;
import baseball.util.Input;
import baseball.util.View;

public class GameManager {
    private final int GAME_RESTART = GameFlow.GAME_RESTART.getValue();
    private BaseballGame game;

    public GameManager() {
    }

    public void run() {
        do {
            game = new BaseballGame();
            game.play();
        } while (isRestart());
    }

    public boolean isRestart() {
        View.printRequestRestart();
        int restartFlag = Integer.parseInt(Input.inputRestartFlag());
        return (restartFlag == GAME_RESTART);
    }
}
