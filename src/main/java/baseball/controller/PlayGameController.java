package baseball.controller;

import baseball.service.GameService;

public class PlayGameController {
    public void startGame() {
        GameService gameService = new GameService();
        gameService.callStartOrder();
        run();
    }

    public void run() {
        GameService gameService = new GameService();
        gameService.makeRandomBall();
        gameService.catchRandomBall();
    }
}