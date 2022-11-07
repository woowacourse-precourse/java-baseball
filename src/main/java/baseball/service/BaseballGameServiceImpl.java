package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.BaseballGameRuleImpl;
import baseball.domain.Computer;
import baseball.domain.GameRule;
import baseball.domain.User;
import baseball.filter.BaseballGameUserInputFilterImpl;
import baseball.filter.UserInputFilter;
import baseball.restrict.RestrictIntegerConstants;
import baseball.view.TotalViewImpl;

public class BaseballGameServiceImpl implements GameService, RestrictIntegerConstants {

	private final User user;
	private final Computer computer;
	private final TotalViewImpl view;
	private final GameRule<Integer> baseballGameRule;
	private final UserInputFilter<Integer> filter;
	private final List<Integer> status;
	private final List<Integer> result;
	private boolean finishGame;
	private boolean firstGame;

	public BaseballGameServiceImpl() {
		user = new User();
		computer = new Computer();
		view = new TotalViewImpl();
		baseballGameRule = new BaseballGameRuleImpl();
		filter = new BaseballGameUserInputFilterImpl();
		status = new ArrayList<>();
		result = new ArrayList<>();
		finishGame = false;
		firstGame = true;
	}

	@Override
	public void startGame() {
		if (firstGame) {
			view.printStartMessage();
		}
		computer.makeRandomNumber();
		while (!finishGame) {
			makeUserInputNumberList();
			makeStatus();
			makeResult();
			printResult();
			checkFinishGame();
		}
		if (checkRestartOrExit()) {
			restartGame();
		} else {
			exitGame();
		}
	}

	@Override
	public void restartGame() {
		user.clearUserInputNumberList();
		computer.clearRandomNumberList();
		finishGame = false;
		firstGame = false;
		startGame();
	}

	@Override
	public void exitGame() {
	}


	private void checkFinishGame() {
		if (result.size() == RESULT_SIZE && result.get(1) == LIMIT_LIST_SIZE) {
			finishGame = true;
		}
	}

	private boolean checkRestartOrExit() {
		String userInputString;
		List<Integer> bindingResultList;
		int resultNumber = -1;

		view.printEndMessage();
		userInputString = user.readUserInputString();
		if (filter.checkUserInput(userInputString, 1, RESTART_NUMBER, EXIT_NUMBER)) {
			bindingResultList = filter.bindingResult(userInputString, 1);
			resultNumber = bindingResultList.get(0);
		}
		return resultNumber == RESTART_NUMBER;
	}

	private void makeUserInputNumberList() {
		String userInputString;
		List<Integer> bindingResultList;

		view.printInputMessage();
		userInputString = user.readUserInputString();
		if (filter.checkUserInput(userInputString, LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER)) {
			bindingResultList = filter.bindingResult(userInputString, LIMIT_LIST_SIZE);
			user.clearUserInputNumberList();
			user.addAllUserInputNumberList(bindingResultList);
		}
	}

	private void makeStatus() {
		status.clear();
		status.addAll(user.getUserInputNumberList());
		status.addAll(computer.getRandomNumberList());
	}

	private void makeResult() {
		result.clear();
		baseballGameRule.makeResultByGameRule(status);
		result.addAll(baseballGameRule.getResultByGameRule());
	}

	private void printResult() {
		int countBall;
		int countStrike;

		if (result.size() == RESULT_SIZE) {
			countBall = result.get(0);
			countStrike = result.get(1);
			if (countStrike == LIMIT_LIST_SIZE) {
				view.printStrikeMessage(countStrike);
				view.printAnswerMessage();
			} else if (countBall != 0 && countStrike != 0) {
				view.printBallAndStrikeMessage(countBall, countStrike);
			} else if (countBall != 0) {
				view.printBallMessage(countBall);
			} else if (countStrike != 0) {
				view.printStrikeMessage(countStrike);
			} else {
				view.printNothingMessage();
			}
		}
	}
}
