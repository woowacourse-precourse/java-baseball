package baseball.controller;

import baseball.domain.GameResult;
import baseball.service.BaseBallGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
	private static final int CYCLE_END_NUMBER = 3;
	private BaseBallGameService baseBallGameService;

	public BaseballGameController() {
		OutputView.printStartMessage();
	}

	public void startBaseBallGame() {
		this.baseBallGameService = new BaseBallGameService();
		String userChoice;
		do {
			playGame();
			OutputView.printClearMessage();
			userChoice = InputView.printInputRestartMessage();
		} while (baseBallGameService.wantRestart(userChoice));
	}

	private void playGame() {
		GameResult result;
		baseBallGameService.initBaseBallGame();
		do {
			String userInput = InputView.printInputNumberMessage();
			result = baseBallGameService.compareTwoNumber(userInput);
			new OutputView(result).printGameResult();
		} while ((!isGameClear(result.strikeCount)));
	}

	private boolean isGameClear(int strikeCount) {
		return strikeCount == CYCLE_END_NUMBER;
	}
}
