package baseball.view;

import baseball.constant.ViewConstants;

public class OutputView {
	private static final String SPACE = " ";

	public static void printGameStartMessage() {
		System.out.println(ViewConstants.GAME_START_MESSAGE.get());
	}

	public static void printResult(int ballsCount, int strikesCount) {
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

	public static void printStrikesCountMessage(int strikesCount) {
		System.out.printf(ViewConstants.STRIKES_COUNT_MESSAGE.get(), strikesCount);
	}

	public static void printBallsCountMessage(int ballsCount) {
		System.out.printf(ViewConstants.BALLS_COUNT_MESSAGE.get(), ballsCount);
	}

	public static void printNothingMessage() {
		System.out.println(ViewConstants.NOTHING_MESSAGE.get());
	}

	public static void printGettingRightAnswerMessage(int lengthOfNumber) {
		System.out.printf(ViewConstants.GETTING_RIGHT_ANSWER_MESSAGE.get(), lengthOfNumber);
		System.out.println();
	}

}
