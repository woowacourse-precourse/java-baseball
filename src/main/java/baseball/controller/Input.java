package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String getGameNumber() {
		while (true) {
			try {
				String inputGameNumber = getInputGameNumber();
				Exception.validOnlyOneToNine(inputGameNumber);
				Exception.validNumberLength(inputGameNumber);
				Exception.validOverlapNumber(inputGameNumber);
				return inputGameNumber;
			} catch (IllegalArgumentException error) {
				System.out.println(error);
			}
		}
	}

	private static String getInputGameNumber() {
		return Console.readLine();
	}
}
