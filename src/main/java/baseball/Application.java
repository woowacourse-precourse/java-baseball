package baseball;

import baseball.controller.GameController;
import baseball.model.NumberBaseBallGame;
import baseball.view.NumberBaseBallView;

public class Application {
    public static void main(String[] args) {
        NumberBaseBallView numberBaseBallView = new NumberBaseBallView();
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame();

        GameController gameController = new GameController(numberBaseBallGame, numberBaseBallView);
        gameController.start();
    }
}
