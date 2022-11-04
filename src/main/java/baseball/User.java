package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public static void getUserInput() {
		GameView.printStartGame();
		GameView.printInstruction();
		String userInput = Console.readLine();
		System.out.println(userInput);
		System.out.println(convertUserInputToList(userInput));
	}

	public static List<Integer> convertUserInputToList(String userInput) {
		List<Integer> userInputList = new ArrayList<>();
		for (int i = 0; i < userInput.length(); i++) {
			userInputList.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
		}
		return userInputList;
	}
}
