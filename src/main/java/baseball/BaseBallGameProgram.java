package baseball;

import java.util.List;
import java.util.stream.IntStream;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.input.GameCommand;
import baseball.input.Input;
import baseball.input.InputLength;
import baseball.validation.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameProgram {
	private static final int MAX_STRIKE = 3;
	private static final int INIT = 0;
	private static Computer computer;
	private static Player player;
	private int strike;
	private int ball;
	private static boolean isEnd = false;

	public BaseBallGameProgram(Computer computer, Player player) {
		this.computer = computer;
		this.player = player;
	}

	public void baseBallGame() {
		do {
			InputView.showStartGameGuideMessage();
			computer.makeRandomNumber();
			matchingNumbers();
			isEnd = gameCommand();
		} while (!isEnd);
	}

	private boolean gameCommand() {
		InputView.showGameCommandGuideMessage();
		String playerInput = Input.inputNumber();
		Validation.validateGameCommand(playerInput);

		return isEndCommand(Integer.parseInt(playerInput));
	}

	private void matchingNumbers() {
		do {
			initBallAndStrike();
			playerGuessNumber();
			calculateStrikeAndBall(computer.getRandomNumber(), player.getPlayerNumberList());
			OutputView.showResult(ball, strike);
		} while (strike != MAX_STRIKE);

		OutputView.showThreeStrike();
	}

	private void playerGuessNumber() {
		InputView.showPlayerInputGuideMessage();

		String userInput = Input.inputNumber();
		Validation.validatePlayerInput(userInput);
		player.addPlayerNumberInList(userInput);
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
