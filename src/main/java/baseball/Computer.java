package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
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

	public static void resetComputerNums() {
		computerNums.clear();
	}
}
