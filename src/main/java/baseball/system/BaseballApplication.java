package baseball.system;

import baseball.controller.BaseBallController;
import baseball.controller.ComputerController;

public class BaseballApplication {
    public static void run() {
        doSetting();
        BaseBallController baseBallController = new BaseBallController();
        baseBallController.startGame();
    }

    private static void doSetting() {
        ComputerController computerController = new ComputerController();
        computerController.createAnswer();
    }
}
