package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {

    private BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    // 게임 생성
    public void createGame() {
        baseballService.welcome();
        do {
            startGame();
        } while (baseballService.reStart());
    }

    // 게임 시작
    private void startGame() {
        baseballService.initGame();
        do {
            baseballService.playBaseballGame();
            baseballService.displayHint();
        } while (!baseballService.isCorrect());
    }
}
