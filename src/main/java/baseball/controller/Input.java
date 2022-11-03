package baseball.controller;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	public static List<Integer> getGameNumber() {
		while (true) {
			try {
				InputView.printInputNumber();
				String inputGameNumber = getInputGameNumber();
				Exception.validOnlyOneToNine(inputGameNumber);
				Exception.validNumberLength(inputGameNumber);
				Exception.validOverlapNumber(inputGameNumber);
				return stringToList(inputGameNumber);
			} catch (IllegalArgumentException error) {
				System.out.println(error);
			}
		}
	}

	private static String getInputGameNumber() {
		return Console.readLine();
	}

	private static List<Integer> stringToList(String inputGameNumber) {
		String[] gameNumberArray = inputGameNumber.split("");
		return Arrays.stream(gameNumberArray)
			.map(gameNumber -> Integer.parseInt(gameNumber))
			.collect(Collectors.toList());
	}
}
