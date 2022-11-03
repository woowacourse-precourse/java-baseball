package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;

	private static final int NUMBER_LIST_LENGTH = 3;

	public static List<Integer> getNumbers() {
		List<Integer> numbersList = new ArrayList<>();
		while (numbersList.size() < NUMBER_LIST_LENGTH) {
			addNumberList(numbersList);
		}
		return numbersList;
	}

	static int getRandomNumber() {
		return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
	}

	static void addNumberList(List<Integer> numbersList) {
		int randomNumber = getRandomNumber();
		if (!numbersList.contains(randomNumber)) {
			numbersList.add(randomNumber);
		}
	}
}
