package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();

        while (true) {
            String restartGameValue = "1";
            if (!gameController.runningGame()) {
                restartGameValue = gameController.restartGame();
            }

            if (restartGameValue.equals("2")) {
                break;
            }

        }
    }

}
