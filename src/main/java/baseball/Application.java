package baseball;

import baseball.service.BaseBallGame;
import baseball.controller.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        BaseBallGameController baseBallGameController = new BaseBallGameController(baseBallGame);
        baseBallGameController.startGame();
    }
}