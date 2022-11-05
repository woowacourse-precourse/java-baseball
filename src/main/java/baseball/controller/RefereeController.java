package baseball.controller;

import baseball.Ball;
import baseball.Result;
import baseball.service.RefereeService;

import java.util.List;

public class RefereeController {
    private final RefereeService refereeService;

    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    public Result generateResult(List<Ball> computerBalls, List<Ball> playerBalls) {
        return refereeService.generateResult(computerBalls, playerBalls);
    }
}
