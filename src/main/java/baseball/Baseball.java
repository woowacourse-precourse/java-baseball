package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
	private final int PLAYING_NUMBER_SIZE = 3;
	private final int START_INPUT = 1;
	private final int END_INPUT = 2;
	private final String INPUT_ERROR_MESSAGE = "%d 또는 %d만 입력해주세요";
	private final String STRIKE_MESSAGE = "%d스트라이크";

	private boolean isKeepInning = true;
	private boolean isKeepGaming = true;

	public void startGame() {
		while (isKeepGaming) {
			playInning();
			Broadcast.printRestartMessage(START_INPUT, END_INPUT);
			checkGameEnd();
		}
	}

	private void playInning() {
		Broadcast.printStartMessage();
		Pitcher computerNumber = new Pitcher();
		while (isKeepInning) {
			Broadcast.printInputMessage();
			Batter userInputNumber = new Batter();
			Referee calculateResult = new Referee(computerNumber, userInputNumber);
			String resultMessage = calculateResult.getResultMessage();
			Broadcast.printResultMessage(resultMessage);
			checkInningEnd(resultMessage);
		}
	}

	private void checkInningEnd(String resultMessage) {
		if (resultMessage.equals(String.format(STRIKE_MESSAGE, PLAYING_NUMBER_SIZE))) {
			isKeepInning = false;
			Broadcast.printEndMessage(PLAYING_NUMBER_SIZE);
		}
	}

	private void checkGameEnd() {
		String endCode = Console.readLine();
		if (endCode.equals(Integer.toString(START_INPUT))) {
			isKeepInning = true;
			return;
		}
		if (endCode.equals(Integer.toString(END_INPUT))) {
			isKeepGaming = false;
			return;
		}
		throw new IllegalArgumentException(String.format(INPUT_ERROR_MESSAGE, START_INPUT, END_INPUT));
	}
}
