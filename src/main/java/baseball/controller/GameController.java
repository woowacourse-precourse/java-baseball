package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private GameService gameService = new GameService();
    private final int DIGIT = 3;
    private final int START_RANGE = 1;
    private final int END_RANGE = 9;

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
