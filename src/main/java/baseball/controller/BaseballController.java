package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
    }

    public void Start() {
        baseballService.gameStart();
    }
}
