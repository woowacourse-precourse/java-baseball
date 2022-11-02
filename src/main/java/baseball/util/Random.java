package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {

	private static final int SIZE = 3;
	private static final int START_INCLUSIVE = 1;
	private static final int END_INCLUSIVE = 9;
	private static final List<Integer> threeUniqueNumbers = new ArrayList<>(SIZE);

	public static List<Integer> getThreeUniqueNumber() {
		int randomNumber;

		while (threeUniqueNumbers.size() <= SIZE) {
			randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

			if (threeUniqueNumbers.contains(randomNumber)) {
				continue;
			}

			threeUniqueNumbers.add(randomNumber);
		}

		return threeUniqueNumbers;
	}

}
