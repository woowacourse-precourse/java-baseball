package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.SystemMessage;

public class Application {
    public static void main(String[] args) {
        SystemMessage.printGameStartMessage();
        BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.run();
    }
}
