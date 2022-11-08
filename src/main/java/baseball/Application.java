package baseball;

import baseball.controller.NumberBaseballController;

public class Application {
    public static void main(String[] args) {
        NumberBaseballController numberBaseballController = new NumberBaseballController();
        numberBaseballController.startGame();
    }
}
