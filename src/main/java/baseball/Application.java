package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController baseballController = new GameController();
        baseballController.run();
    }
}
