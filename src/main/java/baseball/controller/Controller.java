package baseball.controller;

import baseball.service.Game;
import baseball.view.RequestPlayerInput;
import camp.nextstep.edu.missionutils.Console;

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
		game.endGame();
    }

    public void retry() {
		RequestPlayerInput.requestRetry();
		String retryNumber = Console.readLine();

		if (retryNumber.equals("1")) {
			run();
			return;
		}
		if (!retryNumber.equals("2")) {
			throw new IllegalArgumentException();
		}
    }
}
