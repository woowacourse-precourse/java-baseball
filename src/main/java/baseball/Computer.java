package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int INIT_LIST_CAPACITY = 3;
	private List<Integer> randomNumber;

	public Computer() {
		randomNumber = new ArrayList<>(INIT_LIST_CAPACITY);
		makeRandomNumber();
	}

	protected void makeRandomNumber() {
		initRandomNumber();
		selectNumber();
	}

	private void initRandomNumber() {
		randomNumber.clear();
	}

	private void selectNumber() {

		while (randomNumber.size() < INIT_LIST_CAPACITY) {
			int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

			if (!Checker.isSameNumberExistInRandomNumber(number,randomNumber)) {
				addRandomNumber(number);
			}
		}
	}

	private boolean addRandomNumber(int number) {
		return randomNumber.add(number);
	}

	public List<Integer> getRandomNumber() {
		return randomNumber;
	}
}
