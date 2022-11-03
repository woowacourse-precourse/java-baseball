package baseball.controller;

import java.util.List;

import baseball.domain.ComputerNumber;
import baseball.domain.GameResult;
import baseball.domain.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
	public void run() {
		runOneCycle();
	}

	private void runOneCycle() {
		int strikeCount;
		List<Integer> computerNums = new ComputerNumber().computerNumber;
		do {
			List<Integer> userNums = new UserNumber(InputView.printInputNumberMessage()).userNumber;
			GameResult result = new GameResult(computerNums, userNums);
			strikeCount = result.strikeCount;
			new OutputView(result).printGameResult();
		} while (isGameEnd(strikeCount));
	}

	private boolean isGameEnd(int result) {
		return result == 3;
	}
}
