package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {
    private BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    public void startProgram() {
        baseballService.hello();
        do {
            startGame();
        } while (baseballService.isRestart());
    }

    private void startGame() {
        baseballService.initGame();
        do {
            baseballService.playGame();
        } while (!baseballService.isCorrect());
    }


}
