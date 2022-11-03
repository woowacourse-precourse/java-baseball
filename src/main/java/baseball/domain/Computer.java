package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private final List<Integer> number;

	public Computer() {
		number = new ArrayList<>();
	}

	private void init() {
		number.clear();
	}

	public void generateNumber() {
		init();
		do {
			int randomNumber = Randoms.pickNumberInRange(ConstValue.MINIMUM_NUMBER, ConstValue.MAXIMUM_NUMBER);
			duplicatedNumber(randomNumber);
		} while (number.size() != ConstValue.NUMBER_COUNT);
	}

	private void duplicatedNumber(int randomNumber) {
		if (!number.contains(randomNumber)) {
			number.add(randomNumber);
		}
	}

	public List<Integer> getNumber() {
		return number;
	}
}
