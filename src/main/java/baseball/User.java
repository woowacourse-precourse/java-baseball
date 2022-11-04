package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static void getUserInput() {
		GameView.printStartGame();
		GameView.printInstruction();
		String userInput = Console.readLine();
		checkUserInput(userInput);
		System.out.println(userInput);
	}

	public static List<Integer> convertUserInputToList(String userInput) {
		List<Integer> userInputList = new ArrayList<>();
		for (int i = 0; i < userInput.length(); i++) {
			userInputList.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
		}
		return userInputList;
	}

	public static void checkUserInput(String userInput) {
		InputException.checkNotNumber(userInput);
		InputException.checkLength(userInput);
		InputException.checkDuplicate(convertUserInputToList(userInput));
		InputException.checkZero(convertUserInputToList(userInput));
	}
}
