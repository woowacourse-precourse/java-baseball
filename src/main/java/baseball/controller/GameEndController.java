package baseball.controller;

import baseball.domain.UserBall;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameEndController {

	private final OutputView outputView;
	private final InputView inputView;

	public GameEndController(OutputView outputView, InputView inputView) {
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public boolean isAnswer(UserBall userBall) {
		if (userBall.is3Strike()) {
			printSuccessResult();
			return true;
		}
		return false;
	}

	private void printSuccessResult() {
		outputView.printSuccess();
		inputView.printGameRestart();
	}

}
