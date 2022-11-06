package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
	private static final int STRIKE_OUT = 3;
	private static final int RESTART_NUMBER = 1;
	private static final int EXIT_NUMBER = 2;
	private static InputView inputView = new InputView(RESTART_NUMBER, EXIT_NUMBER);

	public static void startGame() {
		start();
		restart();
	}

	private static void start() {
		inputView.printGameStart();
		RandomNumber randomNumber = new RandomNumber();
		randomNumber.getNumbers().stream().forEach(e -> System.out.print(e));
		System.out.println("");
		playGame(randomNumber);
	}

	private static void playGame(RandomNumber randomNumber) {
		boolean progress = true;

		while (progress) {
			List<Integer> playerNumbers = Input.getPlayerNumbers();
			GameResult gameResult = new GameResult(playerNumbers, randomNumber.getNumbers());
			Judge.getGameResult(gameResult);

			if (isStrikeOut(gameResult)) {
				progress = false;
			}
		}
	}

	private static boolean isStrikeOut(GameResult gameResult) {
		if (gameResult.getStrikeCount() == STRIKE_OUT) {
			OutputView.printGameEnd(STRIKE_OUT);
			return true;
		}
		return false;
	}

	private static void restart() {
		inputView.printRestartOrExit();
		int restartNumber = Input.getRestartNumber(RESTART_NUMBER, EXIT_NUMBER);
		if (restartNumber == RESTART_NUMBER) {
			startGame();
		}
	}
}
