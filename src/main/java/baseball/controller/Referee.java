package baseball.controller;

import baseball.view.OutputView;

public class Referee {
	public static void judgeGame(int ballCount, int strikeCount) {
		judgeStrike(ballCount, strikeCount);
		judgeBall(ballCount, strikeCount);
		judgeNothing(ballCount, strikeCount);
		judgeBallAndStrike(ballCount, strikeCount);
	}

	private static void judgeStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount == 0) {
			OutputView.printStrikeCount(strikeCount);
		}
	}

	private static void judgeBall(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount > 0) {
			OutputView.printBallCount(ballCount);
		}
	}

	private static void judgeNothing(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount == 0) {
			OutputView.printNothing();
		}
	}

	private static void judgeBallAndStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount > 0) {
			OutputView.printBallAndStrikeCount(ballCount, strikeCount);
		}
	}
}
