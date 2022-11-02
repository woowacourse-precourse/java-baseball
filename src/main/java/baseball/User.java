package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {



	private static final int numberDigits = 3;

	public List<Integer> getUserNumber(){

		String userInput = getUserInput();

//		if userInput hasDuplication || !3자리가 아니거나 => again

		List<Integer> numberList = new ArrayList<>();

		return numberList;
	}

	private static String getUserInput() {
		String userInput = Console.readLine();
		return userInput;
	}

	public boolean hasDuplication(CharSequence checkString) {
		return checkString.length() != checkString
				.chars()
				.distinct()
				.count();
	}

	public boolean checkDigit(String checkString, int checkLength){
		return Objects.equals(checkLength, checkString.length());
	}

}
