package baseball;

import baseball.controller.GameController;
import baseball.view.SystemMessage;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        SystemMessage.getStartMessage();
        gameController.runGame();
    }

}
