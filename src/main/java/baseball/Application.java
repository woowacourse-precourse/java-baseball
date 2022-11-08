package baseball;

import baseball.controller.BaseballGame;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        GameController gameController = GameController.from(baseballGame);
        gameController.startGame();
    }
}
