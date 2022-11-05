package baseball.controller;

import baseball.Ball;
import baseball.service.PlayerService;

import java.util.List;

public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public List<Ball> generatePlayerBalls() {
        return playerService.generatePlayerBalls();
    }
}
