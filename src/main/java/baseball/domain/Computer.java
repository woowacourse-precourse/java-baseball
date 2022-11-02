package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MINIMUM_NUMBER = 1;
	private static final int MAXIMUM_NUMBER = 9;
	private static final int NUMBER_COUNT = 3;
	private final List<Integer> number = new ArrayList<>();

	public Computer() {
		do {
			int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
			duplicatedNumber(randomNumber);
		} while (number.size() != NUMBER_COUNT);
	}

	private void duplicatedNumber(int randomNumber) {
		if (!number.contains(randomNumber)){
			number.add(randomNumber);
		}
	}
}
