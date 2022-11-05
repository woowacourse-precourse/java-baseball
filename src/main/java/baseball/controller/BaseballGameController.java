package baseball.controller;

import baseball.view.BaseballGameView;

public class BaseballGameController {

    private final BaseballGameView baseballGameView;

    public BaseballGameController() {
        this.baseballGameView = new BaseballGameView();
    }

    public void initGame() {
        baseballGameView.displayGameStart();
    }
}
