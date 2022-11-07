package baseball.controller;

import baseball.service.GameService;
import baseball.utils.Message;

public class GameController {
    private GameService gameService = new GameService();
    private final int DIGIT = 3;
    private final int START_RANGE = 1;
    private final int END_RANGE = 9;

    public GameController() {
        setGame();
    }

    private void setGame() {
        gameService.setGame(DIGIT, START_RANGE, END_RANGE);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.startGame();
    }

    private void endGame() throws IllegalArgumentException {
        if (gameService.isReplay()) {
            run();
        }
        Message.printEndProgram();
    }

    public void run() throws IllegalArgumentException {
        startGame();
        endGame();
    }
}
