package baseball.view;

import baseball.constant.GameConstants;
import baseball.constant.ViewConstants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private void printAskingInputMessage() {
		System.out.print(ViewConstants.ASKING_INPUT_MESSAGE.get());
	}

	private void printRestartOrNotMessage() {
		System.out.printf(ViewConstants.RESTART_OR_NOT_MESSAGE.get(), GameConstants.RESTART_GAME,
			GameConstants.END_GAME);
		System.out.println();
	}

	public String getNumberFromUser() {
		printAskingInputMessage();
		return Console.readLine();
	}

	public String getRestartRequest() {
		printRestartOrNotMessage();
		return Console.readLine();
	}
}
