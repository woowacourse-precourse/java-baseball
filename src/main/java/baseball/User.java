package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static List<Integer> userNums;

	public static void getUserInput() {
		GameView.printStartGame();
		GameView.printInstruction();
		String userInput = Console.readLine();
		checkUserInput(userInput);
		System.out.println(userInput);
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
}
