package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public static List<Integer> userNums;

	private User() {
	}

	public static void inputNumber() {
		GameView.printInstruction();
		String userInput = Console.readLine();
		checkUserInput(userInput);
	}

	public static List<Integer> convertUserInputToList(String userInput) {
		userNums = new ArrayList<>();
		for (int i = 0; i < userInput.length(); i++) {
			userNums.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
		}
		return userNums;
	}

	public static void checkUserInput(String userInput) {
		InputException.checkNotNumber(userInput);
		InputException.checkLength(userInput);
		InputException.checkDuplicate(convertUserInputToList(userInput));
		InputException.checkZero(convertUserInputToList(userInput));
	}

	public static boolean isRestart() {
		String userInput = Console.readLine();
		checkRestartInput(userInput);
		return isEqualToRestart(userInput);
	}

	private static void checkRestartInput(String userInput) {
		InputException.checkNotNumber(userInput);
		InputException.checkNotOneOrTwo(userInput);
	}

	private static boolean isEqualToRestart(String userInput) {
		return userInput.equals(RESTART);
	}
}
