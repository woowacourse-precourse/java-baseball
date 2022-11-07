package baseball;

public class BaseballGame {

    Player player = new Player();
    BaseballGameManager baseballGameManager = new BaseballGameManager();
    
    public void start() {
        baseballGameManager.setup();
        do {
            baseballGameManager.provideResult(player.sendAnswer());
        } while (!baseballGameManager.isGameClear());
    }

    public boolean isRestart() {
        if (player.selectOptionAfterGameClear().equals("1")) {
            return true;
        }
        return false;
    }
}
