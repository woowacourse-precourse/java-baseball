package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int NUMBER_LIST_LENGTH = 3;
	private List<Integer> numbers;

	public Computer() {
		this.numbers = createNumbers();
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	private List<Integer> createNumbers() {
		List<Integer> numbersList = new ArrayList<>();
		while (numbersList.size() < NUMBER_LIST_LENGTH) {
			addNumberToList(numbersList);
		}
		return numbersList;
	}

	private void addNumberToList(List<Integer> numbersList) {
		int randomNumber = getRandomNumber();
		if (!numbersList.contains(randomNumber)) {
			numbersList.add(randomNumber);
		}
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
	}
}
