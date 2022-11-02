package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {



	private static final int numberDigits = 3;

	public List<Integer> getUserNumber(){
		List<Integer> numberList = new ArrayList<>();

		String userInput = getUserInput();

		return numberList;
	}

	private static String getUserInput() {
		String userInput = Console.readLine();
		return userInput;
	}


}
