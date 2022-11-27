package baseball;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.input.Input;
import baseball.validation.Validation;
import baseball.view.View;

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
			Validation.userInputChecker(userInput, END_OR_RESTART_INPUT_LENGTH, player.getPlayerNumberList());

			isEnd = Validation.checkEndGame(Integer.parseInt(userInput));
			Validation.checkReStart(computer, !isEnd);
		} while (!isEnd);
	}

	private void game(Computer computer, Player player) {

		do {
			initBallAndStrike();

			View.showUserInputGuideMessage();

			String userInput = Input.inputNumber();
			Validation.userInputChecker(userInput, NUMBERS_INPUT_LENGTH, player.getPlayerNumberList());
			player.addPlayerNumberInList(userInput);

			calculateStrikeAndBall(computer.getRandomNumber(), player.getPlayerNumberList());

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

		if (Validation.isStrike(computerNumber, userNumber)) {
			strike++;
		} else if (Validation.isBall(userNumber, randomNumber)) {
			ball++;
		}

	}
}
