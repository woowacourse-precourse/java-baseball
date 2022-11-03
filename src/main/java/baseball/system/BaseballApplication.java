package baseball.system;

import baseball.controller.BaseBallController;
import baseball.controller.ComputerController;
import baseball.vo.Restart;

public class BaseballApplication {
    public static void run() {
        doSetting();
        BaseBallController baseBallController = new BaseBallController();
        Restart restart = baseBallController.startGame();

        if (restart == Restart.RESTART) {
            run();
        }
    }

    private static void doSetting() {
        ComputerController computerController = new ComputerController();
        computerController.createAnswer();
    }
}
