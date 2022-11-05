package baseball;

import java.util.List;

public class Game {
	private static final int MAX_STRIKE = 3;
	private static final int INIT_INDEX = 0;
	private static final int INIT_STRIKE_AND_BALL = 0;
	private static final int END_OR_RESTART_INPUT_LENGTH = 1;
	private static final int NUMBERS_INPUT_LENGTH = 3;
	private int strike;
	private int ball;

	public void startGame(Computer computer, Player player) {
		boolean isEnd;

		do {
			View.showStartGameGuideMessage();
			game(computer, player);

			View.showEndOrRestartGuideMessage();
			String userInput = Input.inputNumber();
			Checker.userInputChecker(userInput, END_OR_RESTART_INPUT_LENGTH, player.getUserNumberList());

			isEnd = Checker.checkEndGame(Integer.parseInt(userInput));
			Checker.checkReStart(computer, !isEnd);
		} while (!isEnd);
	}

	private void game(Computer computer, Player player) {

		do {
			initBallAndStrike();

			View.showUserInputGuideMessage();

			String userInput = Input.inputNumber();
			Checker.userInputChecker(userInput, NUMBERS_INPUT_LENGTH, player.getUserNumberList());
			player.addUserNumberInList(userInput);

			calculateStrikeAndBall(computer.getRandomNumber(), player.getUserNumberList());

			View.showResult(ball, strike, INIT_STRIKE_AND_BALL);
		} while (strike != MAX_STRIKE);

		View.showThreeStrike();
	}

	private void initBallAndStrike() {
		this.ball = INIT_STRIKE_AND_BALL;
		this.strike = INIT_STRIKE_AND_BALL;
	}

	private void calculateStrikeAndBall(List<Integer> randomNumber, List<Integer> userNumberList) {

		for (int numberIndex = INIT_INDEX; numberIndex < randomNumber.size(); numberIndex++) {

			int computerNumber = randomNumber.get(numberIndex);
			int userNumber = userNumberList.get(numberIndex);

			strikeOrBall(userNumber, computerNumber, randomNumber);
		}

	}

	private void strikeOrBall(int userNumber, int computerNumber, List<Integer> randomNumber) {

		if (Checker.isStrike(computerNumber, userNumber)) {
			strike++;
		} else if (Checker.isBall(userNumber, randomNumber)) {
			ball++;
		}

	}
}
