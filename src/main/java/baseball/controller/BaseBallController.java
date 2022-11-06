package baseball.controller;

import baseball.model.service.BaseBallService;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public void create() {
        baseBallService.create();
    }
}
