package baseball;

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
        if (player.selectOptionAfterGameClear().equals("1")) {
            return true;
        }
        return false;
    }
}
