package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

	private static final int MAX_NUMBER = 9;
	private static final int MIN_NUMBER = 1;

	public int generateNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
