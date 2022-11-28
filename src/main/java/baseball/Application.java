package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartMessage();
        GameController gameController;
        boolean isGameFinished = false;
        while (!isGameFinished) {
            gameController = new GameController();
            gameController.startGame();
            isGameFinished = gameController.finishGame();
        }
    }
}