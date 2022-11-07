package baseball.view;

import baseball.constant.ViewConstants;

public class OutputView {
	private static final String SPACE = " ";

	public void printGameStartMessage() {
		System.out.println(ViewConstants.GAME_START_MESSAGE.get());
	}

	public void printResult(int ballsCount, int strikesCount) {
		if (ballsCount == 0 && strikesCount == 0) {
			printNothingMessage();
			return;
		}
		if (ballsCount != 0) {
			printBallsCountMessage(ballsCount);
			if (strikesCount != 0) {
				System.out.print(SPACE);
			}
		}
		if (strikesCount != 0) {
			printStrikesCountMessage(strikesCount);
		}
		System.out.println();
	}

	public void printStrikesCountMessage(int strikesCount) {
		System.out.printf(ViewConstants.STRIKES_COUNT_MESSAGE.get(), strikesCount);
	}

	public void printBallsCountMessage(int ballsCount) {
		System.out.printf(ViewConstants.BALLS_COUNT_MESSAGE.get(), ballsCount);
	}

	public void printNothingMessage() {
		System.out.println(ViewConstants.NOTHING_MESSAGE.get());
	}

	public void printFinishingGameMessage(int lengthOfNumber) {
		System.out.printf(ViewConstants.FINISHING_GAME_MESSAGE.get(), lengthOfNumber);
		System.out.println();
	}

}
