package baseball.service;

import java.util.List;
import java.util.stream.Collectors;

import baseball.domain.UserBall;
import baseball.view.InputView;
import baseball.view.OutputView;

public class UserBallService {

	private final OutputView outputView;
	private final InputView inputView;

	public UserBallService(OutputView outputView, InputView inputView) {
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public boolean isAnswer(String userInput, List<Integer> answerNumber) {
		UserBall userBall = makeUserBall(userInput, answerNumber);
		if (is3Strike(userBall)) {
			printSuccessResult();
			return true;
		}
		printFailResult(userBall);
		return false;
	}

	private void printSuccessResult() {
		outputView.printSuccess();
		inputView.printRestartGame();
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

	private UserBall makeUserBall(String userInput, List<Integer> answerNumber) {
		List<Integer> userInputList = userInput.chars()
			.mapToObj(num -> Integer.parseInt(num + "") - 48)
			.collect(Collectors.toList());

		UserBall userBall = UserBall.createUserBall();
		updateBallCount(answerNumber, userInputList, userBall);
		updateStrikeCount(answerNumber, userInputList, userBall);
		return userBall;
	}

	private void updateStrikeCount(List<Integer> answerNumber, List<Integer> userInputList, UserBall userBall) {
		for (int i = 0; i < 3; i++) {
			if (userInputList.get(i).equals(answerNumber.get(i))) {
				userBall.changeStrikeCount(userBall.getStrike() + 1);
			}
		}
	}

	private void updateBallCount(List<Integer> answerNumber, List<Integer> userInputList, UserBall userBall) {
		for (int i = 0; i < 3; i++) {
			if (!userInputList.get(i).equals(answerNumber.get(i)) && userInputList.contains(answerNumber.get(i))) {
				userBall.changeBallCount(userBall.getBall() + 1);
			}
		}
	}

}
