package baseball;

import baseball.controller.GameController;

public class Application {
    private static GameController gameController = new GameController();

    public static void main(String[] args) {

        gameController.GameController();
    }
}
