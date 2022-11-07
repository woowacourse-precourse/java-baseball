package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    private BaseballGameService baseballGameService;

    public BaseballGameController() {
        baseballGameService = new BaseballGameService();
    }

    public void run() {
        boolean isPlaying = true;
        while (isPlaying) {
            baseballGameService.gameStart();
            baseballGameService.playing();
            isPlaying = baseballGameService.replay();
        }
    }
}
