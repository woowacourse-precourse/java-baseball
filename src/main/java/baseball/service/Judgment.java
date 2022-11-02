package baseball.service;

import java.util.List;

import baseball.view.OutputView;

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
		printStrikeAndBallMessage();
	}

	private void checkStrikeAndBall(Integer userNumberIndex, Integer computerNumbersIndex) {
		if (computerNumbersIndex == NOTHING) {
			return;
		}
		if (computerNumbersIndex.equals(userNumberIndex)) {
			strikeCount++;
		} else if (computerNumbersIndex < NUMBER_COUNT) {
			ballCount++;
		}
	}

	public boolean threeStrike() {
		return strikeCount != NUMBER_COUNT;
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
