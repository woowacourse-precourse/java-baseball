package baseball.controller;

import baseball.exception.PlayerNumberException;
import baseball.exception.RestartNumberException;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static String getInput() {
		InputView.printInputNumber();
		return Console.readLine();
	}

	public static String getPlayerNumber() {
		String inputPlayerNumber = getInput();
		PlayerNumberException.validatePlayerNumber(inputPlayerNumber);
		return inputPlayerNumber;
	}

	public static int getRestartNumber(int restartNumber, int exitNumber) {
		String inputRestartNumber = getInput();
		RestartNumberException.validateRestartNumber(inputRestartNumber, restartNumber, exitNumber);
		return Integer.parseInt(inputRestartNumber);
	}
}
