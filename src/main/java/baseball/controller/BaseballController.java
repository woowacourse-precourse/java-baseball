package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {

    private BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }
}
