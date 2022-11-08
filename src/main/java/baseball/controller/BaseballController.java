package baseball.controller;

import baseball.service.BaseballService;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
    }

    public void Start() {
        baseballService.gameStart();
        baseballService.generateComputerNumber();
        while (baseballService.checkGameStatus()) {
            baseballService.inputPlayerNumber();
            baseballService.comparator();
            baseballService.outputHint();
        }
    }
}
