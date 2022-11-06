package baseball.controller;

import baseball.service.BaseBallService;
import baseball.view.InputView;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }

    public void run() {
        baseBallService.init();
        InputView.printStartMessage();
    }
}
