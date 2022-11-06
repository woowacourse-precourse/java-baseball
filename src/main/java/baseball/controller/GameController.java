package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private static final GameService gameService = new GameService();
    private static final int DIGIT = 3;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public GameController() {
    }

    public void setGame() {
        gameService.initGame(DIGIT, START_RANGE, END_RANGE);
    }

    public void run() throws IllegalArgumentException {
        setGame();
        gameService.startGame();
    }
}
