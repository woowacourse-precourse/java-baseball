package baseball.controller;

import java.util.List;

import baseball.domain.ComputerNumber;
import baseball.domain.GameResult;
import baseball.domain.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
	private static final String RESTART_NUMBER = "1";
	private static final String END_NUMBER = "2";
	private static final int CYCLE_END_NUMBER = 3;

	public BaseballGameController() {
		OutputView.printStartMessage();
	}

	public void run() {
		do {
			runOneCycle();
		} while (choiceRestart());
	}

	private void runOneCycle() {
		List<Integer> computerNums = new ComputerNumber().getComputerNumber();
		gameStart(computerNums);
		OutputView.printClearMessage();
	}

	private void gameStart(List<Integer> computerNums) {
		int strikeCount;
		do {
			List<Integer> userNums = new UserNumber(InputView.printInputNumberMessage()).getUserNumber();
			GameResult result = new GameResult(computerNums, userNums);
			strikeCount = result.strikeCount;
			new OutputView(result).printGameResult();
		} while ((!isGameEnd(strikeCount)));
	}

	private boolean isGameEnd(int result) {
		return result == CYCLE_END_NUMBER;
	}

	private boolean choiceRestart() throws IllegalArgumentException {
		String userChoice = InputView.printInputRestartMessage();
		if (!isRightInput(userChoice)) {
			throw new IllegalArgumentException();
		}
		return userChoice.equals(RESTART_NUMBER);
	}

	private boolean isRightInput(String input) {
		return input.equals(RESTART_NUMBER) || input.equals(END_NUMBER);
	}
}
