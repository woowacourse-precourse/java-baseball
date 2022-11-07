package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {

    BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        setBaseballGame();
        playingBaseballGame();
    }

    private void setBaseballGame() {
        baseballGameService.setBaseballGame();
    }

    private void playingBaseballGame() {
        baseballGameService.playingBaseballGame();
    }
}
