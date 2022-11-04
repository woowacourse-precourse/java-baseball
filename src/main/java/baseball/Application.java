package baseball;

import baseball.controller.NumberBaseballGameController;

public class Application {
    public static void main(String[] args) {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        numberBaseballGameController.generateOpponentComputer();
        numberBaseballGameController.gameStart();
        numberBaseballGameController.gamePlay();
        numberBaseballGameController.gameRestartOrEnd();
    }
}
