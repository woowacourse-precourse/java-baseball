package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartMessage();
        GameController gameController;
        boolean replay = true;
        while (replay) {
            gameController = new GameController();
            gameController.startGame();
            replay = gameController.replayGame();
        }
    }
}