package baseball;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.util.InputVerifier;
import baseball.util.SystemMessage;

public class Game {

	private static final String WIN_CONDITION = "3스트라이크";

	Player player = new Player();

	public void run() {
		setGame();
	}

	private void setGame() {
		start();
		play();
	}

	private void play() {
		Computer computer = new Computer();
		List<Integer> answer = computer.getNumbers();

		while (true) {
			SystemMessage.printNumberInput();
			String playerInput = getPlayerInput();
			Referee.printResult(answer, playerInput);

			if (Referee.getResult(answer, playerInput).equals(WIN_CONDITION)) {
				SystemMessage.printWin();
				endOrRetry();
				break;
			}
		}
	}

	private void endOrRetry() {
		SystemMessage.printEndOrRetry();

		String playerChoice = player.getInput();

		InputVerifier inputVerifier = new InputVerifier(playerChoice);

		if (!inputVerifier.isInteger()) {
			SystemMessage.printNotInteger();
			throw new IllegalArgumentException(SystemMessage.NOT_INTEGER_MESSAGE);
		}

		if (inputVerifier.isRetryNumber()) {
			play();
		}

		if (inputVerifier.isEndNumber()) {
			SystemMessage.printEnd();
		}

		if (inputVerifier.notRetryOrEndNumber()) {
			SystemMessage.printNotRetryOrEndNumber();
			throw new IllegalArgumentException(SystemMessage.NOT_RETRY_OR_END_NUMBER_MESSAGE);
		}
	}

	private String getPlayerInput() {
		String playerInput = player.getInput();

		InputVerifier inputVerifier = new InputVerifier(playerInput);

		if (!inputVerifier.isInteger()) {
			SystemMessage.printNotInteger();
			throw new IllegalArgumentException(SystemMessage.NOT_INTEGER_MESSAGE);
		}

		if (!inputVerifier.isSizeValid()) {
			SystemMessage.printNotSizeThree();
			throw new IllegalArgumentException(SystemMessage.NOT_THREE_SIZE_MESSAGE);
		}

		if (!inputVerifier.notContainZero()) {
			SystemMessage.printContainsZero();
			throw new IllegalArgumentException(SystemMessage.CONTAINS_ZERO_MESSAGE);
		}

		if (!inputVerifier.isUnique()) {
			SystemMessage.printNotUnique();
			throw new IllegalArgumentException(SystemMessage.NOT_UNIQUE_MESSAGE);
		}

		return playerInput;
	}

	private void start() {
		SystemMessage.printStart();
	}

}
