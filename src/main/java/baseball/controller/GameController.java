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
        gameService.setGame(DIGIT, START_RANGE, END_RANGE);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.startGame();
    }

    private void endGame() throws IllegalArgumentException {
        if (gameService.isReplay()) {
            run();
        }
        System.out.println("게임 종료");
    }

    public void run() throws IllegalArgumentException {
        startGame();
        endGame();
    }
}
