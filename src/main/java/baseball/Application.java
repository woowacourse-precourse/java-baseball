package baseball;

import baseball.game.Game;
import baseball.game.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        Game baseBallGame = gameController.getBaseBallGame();
        baseBallGame.play();
    }
}
