package baseball.controller;

import baseball.service.Game;
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
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
