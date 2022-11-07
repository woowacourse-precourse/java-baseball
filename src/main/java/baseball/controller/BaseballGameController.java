package baseball.controller;

import baseball.service.BaseballGameService;

public class BaseballGameController {
    private BaseballGameService baseballGameService;

    public BaseballGameController() {
        baseballGameService = new BaseballGameService();
    }
}
