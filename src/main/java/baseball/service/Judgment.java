package baseball.service;

import java.util.List;

import baseball.domain.ConstValue;
import baseball.view.OutputView;

public class Judgment {
	private int ballCount;
	private int strikeCount;
	private static final int INIT_COUNT = 0;
	private static final int NOTHING = -1;

	public Judgment() {
		initCounts();
	}

	private void initCounts() {
		ballCount = INIT_COUNT;
		strikeCount = INIT_COUNT;
	}

	public void compareNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
		initCounts();
		for (int userNumberIndex = 0; userNumberIndex < ConstValue.NUMBER_COUNT; userNumberIndex++) {
			Integer computerNumberIndex = findIndex(userNumbers, computerNumbers, userNumberIndex);
			isStrike(userNumberIndex, computerNumberIndex);
			isBall(userNumberIndex, computerNumberIndex);
		}
		printStrikeAndBallMessage();
	}

	private Integer findIndex(List<Integer> userNumbers, List<Integer> computerNumbers, Integer userNumberIndex) {
		return computerNumbers.indexOf(userNumbers.get(userNumberIndex));

	}

	private void isStrike(Integer userNumberIndex, Integer computerNumberIndex) {
		if (computerNumberIndex.equals(userNumberIndex)) {
			strikeCount++;
		}
	}

	private void isBall(Integer userNumberIndex, Integer computerNumberIndex) {
		if (!userNumberIndex.equals(computerNumberIndex) && computerNumberIndex != NOTHING) {
			ballCount++;
		}
	}

	public boolean isThreeStrike() {
		return strikeCount != ConstValue.NUMBER_COUNT;
	}

	private void printStrikeAndBallMessage() {
		if (ballCount == INIT_COUNT && strikeCount == INIT_COUNT) {
			OutputView.printNothing();
		} else if (ballCount == INIT_COUNT) {
			OutputView.printStrike(strikeCount);
		} else if (strikeCount == INIT_COUNT) {
			OutputView.printBall(ballCount);
		} else {
			OutputView.printBallAndStrike(ballCount, strikeCount);
		}
	}
}
