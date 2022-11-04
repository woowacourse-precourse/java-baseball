package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.util.StringToArrayList;
import baseball.util.SystemMessage;

import java.util.List;

public class Game {

	Player player = new Player();

	private static final int RETRY_NUMBER = 1;
	private static final int END_NUMBER = 2;

	public void run() {
		setGame();
	}

	private void setGame() {
		start();
		play();
	}

	private void play() throws IllegalArgumentException {

		Computer computer = new Computer();

		List<Integer> answer = computer.getNumbers();

		while (true) {
			SystemMessage.printNumberInput();

			String playerInput = getPlayerInput();
			List<Integer> playerInputArray = StringToArrayList.convert(playerInput);
			System.out.println(playerInput);

			int strikeCount = Referee.getStrikeCount(answer, playerInputArray);

			Referee.printResult(answer, playerInputArray);

			if (strikeCount == 3) {
				SystemMessage.printWin();
				endOrRetry();
				break;
			}
		}
	}

	private void endOrRetry() {
		SystemMessage.printEndOrRetry();

		int playerChoice = Integer.parseInt(player.getInput());

		System.out.println(playerChoice);

		if (playerChoice == RETRY_NUMBER) {
			play();
		}

		if (playerChoice == END_NUMBER) {
			SystemMessage.printEnd();
		}

		// throw new IllegalArgumentException(SystemMessage.printError()); TODO: 1과 2가 아닌 값이 들어왔을 때 처리 필요
	}

	private String getPlayerInput() throws IllegalArgumentException {
		String playerInput = player.getInput();
		List<Integer> playerInputArray = StringToArrayList.convert(playerInput);

		for (int i = 0; i < playerInput.length(); i++) {
			if (!Character.isDigit(playerInput.charAt(i))) {
				SystemMessage.printNotInteger();
				throw new IllegalArgumentException(SystemMessage.NOT_INTEGER_MESSAGE);
			}
		}

		if (playerInput.length() != 3) {
			SystemMessage.printNotSizeThree();
			throw new IllegalArgumentException(SystemMessage.NOT_THREE_SIZE_MESSAGE);
		}

		if (playerInputArray.contains(0)) {
			System.out.println(playerInput);
			throw new IllegalArgumentException(SystemMessage.printError());
		}

		if (playerInputArray.size() != playerInputArray.stream().distinct().count()) {
			System.out.println(SystemMessage.printError());
			throw new IllegalArgumentException(); //TODO: 에러 메시지 프린트 안되고 있음
		}

		return playerInput;
	}

	private void start() {
		SystemMessage.printStart();
	}

}
