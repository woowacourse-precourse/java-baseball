package baseball.controller;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	public static List<Integer> getGameNumber() {
		String inputGameNumber = getInput();
		Exception.validatePlayerNumber(inputGameNumber);
		return stringToList(inputGameNumber);
	}

	private static String getInput() {
		InputView.printInputNumber();
		return Console.readLine();
	}

	private static List<Integer> stringToList(String inputGameNumber) {
		String[] gameNumberArray = inputGameNumber.split("");
		return Arrays.stream(gameNumberArray)
			.map(gameNumber -> Integer.parseInt(gameNumber))
			.collect(Collectors.toList());
	}

	public static int getRestartNumber(int restartNumber, int exitNumber) {
		String inputRestartNumber = getInput();
		Exception.validateRestartNumber(inputRestartNumber, restartNumber, exitNumber);
		return Integer.parseInt(inputRestartNumber);
	}
}
