package baseball.controller;

import baseball.service.GameService;

public class Controller {

    GameService service = new GameService();

    public void run() {
        setGame();
        playGame();
        endGame();
        askRetry();
    }

    private void setGame() {

    }

    private void playGame() {

    }

    private void endGame() {

    }

    private void askRetry() throws IllegalArgumentException {

    }
}
