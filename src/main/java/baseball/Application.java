package baseball;

import baseball.game.baseball.BaseBallGameRunner;
import baseball.game.baseball.GameRunner;

public class Application {
    public static void main(String[] args) {
        GameRunner gameRunner = new BaseBallGameRunner();
        gameRunner.run();
    }
}
