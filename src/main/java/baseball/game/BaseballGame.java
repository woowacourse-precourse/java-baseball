package baseball.game;

import static baseball.player.InputValidator.GAME_RESTART_OPTION;

import baseball.gamelogic.BaseballGameManager;
import baseball.player.Player;

public class BaseballGame {

    Player player = new Player();
    BaseballGameManager gameManager = new BaseballGameManager();
    
    public void start() {
        gameManager.setup();
        do {
            gameManager.provideResult(player.sendAnswer());
        } while (!gameManager.isGameClear());
    }

    public boolean isRestart() {
        if (player.selectOptionAfterGameClear().equals(GAME_RESTART_OPTION)) {
            return true;
        }
        return false;
    }
}
