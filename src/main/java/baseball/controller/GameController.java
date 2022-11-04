package baseball.controller;

import baseball.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
	private static final int STRIKE_OUT = 3;
	private static final int RESTART_NUMBER = 1;

	public static void startGame() {
		start();
		restart();
	}

	private static void start() {
		InputView.printGameStart();
		RandomNumber randomNumber = new RandomNumber();
		playGame(randomNumber.getNumbers());
	}

	private static void playGame(List<Integer> randomNumbers) {
		while (true) {
			Player player = new Player(Input.getGameNumber());
			Calculator.checkPlayerNumbers(player, randomNumbers);
			Judge.getGameResult(player);

			if (player.getStrike() == STRIKE_OUT) {
				OutputView.printGameEnd(STRIKE_OUT);
				break;
			}
		}
	}

	private static void restart() {
		InputView.printRestartOrExit();
		int restartNumber = Input.getRestartNumber();
		if (restartNumber == RESTART_NUMBER) {
			startGame();
		}
	}
}
