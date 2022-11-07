package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

	public static final int RANGE_START = 1;
	public static final int RANGE_END = 9;

	public static int makeRandomNumber() {

		int hundreds = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
		int tens = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
		int units = Randoms.pickNumberInRange(RANGE_START, RANGE_END);

		while (AnswerChecking.isSameNumber(hundreds, tens, units)) {
			tens = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
			units = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
		}

		return (hundreds * 100) + (tens * 10) + units;
	}

}
