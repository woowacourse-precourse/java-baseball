package baseball.service;

import java.util.List;
import java.util.Objects;

public class Judgment {
	private int ballCount;
	private int strikeCount;
	private static final int INIT_COUNT = 0;
	private static final int NUMBER_COUNT = 3;
	private static final int NOTHING = -1;

	public Judgment() {
		initCount();
	}

	private void initCount() {
		ballCount = INIT_COUNT;
		strikeCount = INIT_COUNT;
	}

	public void compareNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
		initCount();
		for (int userNumberIndex = 0; userNumberIndex < NUMBER_COUNT; userNumberIndex++) {
			checkStrikeAndBall(userNumberIndex, computerNumbers.indexOf(userNumbers.get(userNumberIndex)));
		}
	}

	private void checkStrikeAndBall(Integer userNumberIndex, Integer computerNumbersIndex) {
		if (computerNumbersIndex == NOTHING) {
			return;
		}
		if (computerNumbersIndex.equals(userNumberIndex)) {
			strikeCount++;
		}
		if (computerNumbersIndex < NUMBER_COUNT) {
			ballCount++;
		}
	}


}
