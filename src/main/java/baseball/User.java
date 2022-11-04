package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.Objects;

import static baseball.Configure.*;

public class User {


	public LinkedHashMap<Integer, Integer> getNumbers() {
		System.out.println("숫자를 입력해주세요 : ");
		String input = getInput();

		handleGuessingInputError(input);

		return processNumbers(input);
	}

	public int getIntention() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
		String answer = getInput();

		handleIntentionInputError(answer);

		return Integer.parseInt(answer);
	}

	public LinkedHashMap<Integer, Integer> processNumbers(String input) {
		return storeIntoMap(storeIntoArray(input));
	}

	public LinkedHashMap<Integer, Integer> storeIntoMap(String[] numbersArray) {

		LinkedHashMap<Integer, Integer> numbersWithIdx = new LinkedHashMap<>();

		for (int idx = 0; idx < numbersArray.length; idx++) {
			numbersWithIdx.put(Integer.parseInt(numbersArray[idx]), idx);
		}

		return numbersWithIdx;
	}

	private static String[] storeIntoArray(String input) {
		return input.split("");
	}

	public void handleGuessingInputError(String userInput) {

		if (hasDuplication(userInput) || !followDigitRule(userInput, NUMBER_DIGIT.getValue()) || !isNumberOnly(userInput)) {
			throw new IllegalArgumentException("잘못입력하였습니다. 프로그램을 종료합니다.");
		}

	}

	public void handleIntentionInputError(String userInput) {

		if (!isNumberOnly(userInput) || !isNumberOneOrTwo(userInput)) {
			throw new IllegalArgumentException("잘못입력하였습니다. 프로그램을 종료합니다.");
		}

	}

	private static String getInput() {
		return Console.readLine();
	}

	public boolean hasDuplication(CharSequence checkString) {
		return checkString.length() != checkString
				.chars()
				.distinct()
				.count();
	}

	public boolean followDigitRule(String checkString, int checkLength) {
		return Objects.equals(checkLength, checkString.length());
	}

	public boolean isNumberOnly(String checkString) {
		return checkString.matches("[0-9]+");
	}

	public boolean isNumberOneOrTwo(String checkString) {
		return checkString.matches("[1-2]+");
	}

}
