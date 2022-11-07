package baseball.controller;

import baseball.service.GameProcessor;

public class BaseBallGame {

    private final GameProcessor gameProcessor;

    public BaseBallGame() {
        this.gameProcessor = new GameProcessor();
    }

    public void run() {
        gameProcessor.startGame();
        gameProcessor.playGame();
        endOrRestart();
    }

    private void endOrRestart() {
        if (gameProcessor.endOrRestartGame()) {
            this.run();
        }
    }
}
