package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

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
		Computer computer = new Computer();
		playGame(computer);
	}

	private static void playGame(Computer computer) {
		boolean progress = true;
		while (progress) {
			Player player = new Player(Input.getPlayerNumber());
			GameResult gameResult = new GameResult(player.getNumbers(), computer.getNumbers());
			Referee.judgeGame(gameResult.getBallCount(), gameResult.getStrikeCount());

			if (isStrikeOut(gameResult.getStrikeCount())) {
				progress = false;
			}
		}
	}

	private static boolean isStrikeOut(int strikeCount) {
		if (strikeCount == STRIKE_OUT) {
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
