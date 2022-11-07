package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.SystemMessage;

public class BaseballGameController {

    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        setBaseballGame();
        playingBaseballGame();
        baseballGameOver();
    }

    private void setBaseballGame() {
        baseballGameService.setBaseballGame();
    }

    private void playingBaseballGame() {
        baseballGameService.playingBaseballGame();
    }

    private void baseballGameOver() {
        SystemMessage.printWinMessage();
    }
}
