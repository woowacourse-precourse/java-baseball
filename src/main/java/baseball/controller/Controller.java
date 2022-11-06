package baseball.controller;

import baseball.service.Game;

public class Controller {

	Game game = new Game();
    public void run() {
        prepareGame();
        playGame();
        endGame();
        retry();
    }

    public void prepareGame() {
		game.prepareGame();
    }

    public void playGame() {
		game.playGame();
    }

    public void endGame() {

    }

    public void retry() {

    }
}
