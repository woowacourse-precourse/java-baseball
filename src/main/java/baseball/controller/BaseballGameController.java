package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private final BaseballGameView baseballGameView;
    private BaseballGameService baseballGameService;

    public BaseballGameController() {
        this.baseballGameView = new BaseballGameView();
        this.baseballGameService = new BaseballGameService();
    }

    public void initGame() {
        baseballGameView.displayGameStart();
        baseballGameView.displayPleaseEnterNumber();
    }
}
