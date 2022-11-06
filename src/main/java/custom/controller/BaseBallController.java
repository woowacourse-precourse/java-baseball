package custom.controller;

import custom.dto.Response;
import custom.service.BaseBallService;

public class BaseBallController {
    private final BaseBallService baseBallService;

    public BaseBallController(BaseBallService baseBallService) {
        this.baseBallService = baseBallService;
    }

    public Response init() {
        return baseBallService.init();
    }
}
