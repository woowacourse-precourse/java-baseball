package baseball.view;

import baseball.constant.GameConstants;
import baseball.constant.ViewConstants;
import baseball.utils.InputGetter;

public class InputView {

	private static void printAskingInputMessage() {
		System.out.print(ViewConstants.ASKING_INPUT_MESSAGE.get());
	}

	private static void printRestartOrNotMessage() {
		System.out.printf(ViewConstants.RESTART_OR_NOT_MESSAGE.get(), GameConstants.RESTART_GAME,
			GameConstants.END_GAME);
		System.out.println();
	}

	public String getNumberFromUser() {
		printAskingInputMessage();
		return InputGetter.getUserInput();
	}

	public String getRestartResponse() {
		printRestartOrNotMessage();
		return InputGetter.getUserInput();
	}
}
