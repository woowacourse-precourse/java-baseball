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
		if (is3Strike(userBall)) {
			printSuccessResult();
			return true;
		}
		printFailResult(userBall);
		return false;
	}

	private void printSuccessResult() {
		outputView.printSuccess();
		inputView.printGameRestart();
	}

	private boolean is3Strike(UserBall userBall) {
		return userBall.getStrike() == 3;
	}

	private void printFailResult(UserBall userBall) {
		if (userBall.getStrike() == 0 && userBall.getBall() == 0) {
			outputView.printNothing();
		}

		if (userBall.getBall() != 0 && userBall.getStrike() != 0) {
			outputView.printBallAndStrike(userBall);
		}

		if (userBall.getBall() != 0 && userBall.getStrike() == 0) {
			outputView.printBall(userBall);
		}

		if (userBall.getStrike() != 0 && userBall.getBall() == 0) {
			outputView.printStrike(userBall);
		}
	}

}
