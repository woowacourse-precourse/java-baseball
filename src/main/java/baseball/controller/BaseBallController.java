package baseball.controller;

import baseball.controller.dto.BaseBallDto;
import baseball.model.domain.BaseBall;
import baseball.model.service.BaseBallService;

public class BaseBallController {

    private final BaseBallService baseBallService;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public BaseBallDto.Response create() {
        BaseBall baseBall = baseBallService.create();

        return BaseBallDto.Response.from(baseBall);
    }

    public BaseBallDto.Response match(Long id, String input) {
        BaseBall baseBall = baseBallService.match(id, input);

        return BaseBallDto.Response.from(baseBall);
    }
}
