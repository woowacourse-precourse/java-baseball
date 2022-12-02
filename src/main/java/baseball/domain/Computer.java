package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.input.NumberRange;
import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int INIT_RANDOM_NUMBER_CAPACITY = 3;
	private List<Integer> randomNumber;

	public Computer() {
		randomNumber = new ArrayList<>(INIT_RANDOM_NUMBER_CAPACITY);
	}

	public void makeRandomNumber() {
		initRandomNumber();
		selectNumber();
	}

	private void initRandomNumber() {
		randomNumber.clear();
	}

	private void selectNumber() {

		while (randomNumber.size() < INIT_RANDOM_NUMBER_CAPACITY) {
			int number = Randoms.pickNumberInRange(NumberRange.MIN.getNumber(), NumberRange.MAX.getNumber());

			if (!Validation.isSameNumberExistInRandomNumber(number, randomNumber)) {
				addRandomNumber(number);
			}
		}
	}

	private boolean addRandomNumber(int number) {
		return randomNumber.add(number);
	}

	public List<Integer> getRandomNumber() {
		return Collections.unmodifiableList(randomNumber);
	}
}
