package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int MINIMUM_NUMBER = 1;
	private static final int MAXIMUM_NUMBER = 9;
	private static final int NUMBER_COUNT = 3;
	public static List<Integer> number = new ArrayList<>();

	public Computer() {
		do {
			int RandomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
			number.add(RandomNumber);
		} while (number.size() != NUMBER_COUNT);

	}
}
