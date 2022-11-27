package baseball;

import java.util.List;
import java.util.stream.IntStream;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.input.GameCommand;
import baseball.input.Input;
import baseball.input.InputLength;
import baseball.validation.Validation;
import baseball.view.View;

public class Game {
	private static final int MAX_STRIKE = 3;
	private static final int INIT = 0;
	private int strike;
	private int ball;

	public void start(Computer computer, Player player) {
		boolean isEnd;

		do {
			View.showStartGameGuideMessage();
			computer.makeRandomNumber();
			game(computer, player);
			isEnd = gameCommand();
		} while (!isEnd);
	}

	private boolean gameCommand() {
		View.showGameCommandGuideMessage();
		String playerInput = Input.inputNumber();
		Validation.validateGameCommand(playerInput);

		return isEndCommand(Integer.parseInt(playerInput));
	}

	private void game(Computer computer, Player player) {
		do {
			initBallAndStrike();
			playerGuessNumber(player);
			calculateStrikeAndBall(computer.getRandomNumber(), player.getPlayerNumberList());
			View.showResult(ball, strike);
		} while (strike != MAX_STRIKE);

		View.showThreeStrike();
	}

	private void playerGuessNumber(Player player) {
		View.showPlayerInputGuideMessage();

		String userInput = Input.inputNumber();
		player.addPlayerNumberInList(userInput);

		Validation.validatePlayerInput(userInput, InputLength.NUMBER_INPUT_LENGTH.getLength(),
			player.getPlayerNumberList());
	}

	private void initBallAndStrike() {
		this.ball = INIT;
		this.strike = INIT;
	}

	private void calculateStrikeAndBall(List<Integer> randomNumber, List<Integer> userNumberList) {
		IntStream.range(INIT, randomNumber.size()).forEach(numberIndex -> {
			int computerNumber = randomNumber.get(numberIndex);
			int userNumber = userNumberList.get(numberIndex);
			strikeOrBall(userNumber, computerNumber, randomNumber);
		});
	}

	private void strikeOrBall(int userNumber, int computerNumber, List<Integer> randomNumber) {
		if (Validation.isStrike(computerNumber, userNumber)) {
			strike++;
		} else if (Validation.isBall(userNumber, randomNumber)) {
			ball++;
		}
	}

	private boolean isEndCommand(int playerInput) {
		if (playerInput == GameCommand.END.getCommand()) {
			return true;
		}

		return false;
	}
}
