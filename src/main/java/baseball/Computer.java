package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private static final int NUMBER_LENGTH = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	static final List<Integer> computerNums = new ArrayList<>();

	public Computer() {
		generateRandomThreeNums();
		System.out.println(computerNums);
	}

	private void generateRandomThreeNums() {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			int randomNum = getRandomNum();
			if (isContains(randomNum)) {
				i--;
				continue;
			}
			computerNums.add(randomNum);
		}
	}

	private static int getRandomNum() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}

	private boolean isContains(int randomNum) {
		return computerNums.contains(randomNum);
	}
}
