package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        boolean isRun = true;

        while (isRun) {
            baseballGameService.setComputer();
            baseballGameService.playBaseballGame();

            if (!runnable()) {
                isRun = false;
            }
        }
    }

    public boolean runnable() {
        return baseballGameService.isRestart();
    }
}
