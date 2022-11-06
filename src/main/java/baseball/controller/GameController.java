package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private static final GameService gameService = new GameService();

    public GameController() {
    }

    public static void run() throws IllegalArgumentException {
        gameService.startGame();
    }
}
