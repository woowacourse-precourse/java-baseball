package baseball;

import baseball.controller.GameController;
import baseball.application.NumberBaseBallGame;
import baseball.repository.BaseNumberRepository;
import baseball.view.NumberBaseBallView;

public class Application {
    public static void main(String[] args) {
        NumberBaseBallView numberBaseBallView = new NumberBaseBallView();
        BaseNumberRepository baseNumberRepository = new BaseNumberRepository();
        NumberBaseBallGame numberBaseBallGame = new NumberBaseBallGame(baseNumberRepository);

        GameController gameController = new GameController(numberBaseBallGame, numberBaseBallView);
        gameController.start();
    }
}
