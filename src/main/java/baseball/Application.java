package baseball;

import baseball.controller.GameController;
import baseball.model.GameNumber;
import baseball.model.NumberBaseBallGame;
import baseball.utils.GameNumberGenerator;
import baseball.view.NumberBaseBallView;

public class Application {
    public static void main(String[] args) {
        GameNumber gameNumber = GameNumberGenerator.generate();
        NumberBaseBallView numberBaseBallView = new NumberBaseBallView();
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(gameNumber);

        GameController gameController = new GameController(numberBaseBallGame, numberBaseBallView);
        gameController.start();
    }
}
