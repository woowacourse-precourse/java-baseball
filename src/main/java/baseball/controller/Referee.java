package baseball.controller;

import baseball.view.OutputView;

public class Judge {
	public static void getGameResult(GameResult gameResult) {
		int ballCount = gameResult.getBallCount();
		int strikeCount = gameResult.getStrikeCount();
		judgeStrike(ballCount, strikeCount);
		judgeBall(ballCount, strikeCount);
		judgeNothing(ballCount, strikeCount);
		judgeBallAndStrike(ballCount, strikeCount);
	}

	public static void judgeStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount == 0) {
			OutputView.printStrikeCount(strikeCount);
		}
	}

	public static void judgeBall(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount > 0) {
			OutputView.printBallCount(ballCount);
		}
	}

	public static void judgeNothing(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount == 0) {
			OutputView.printNothing();
		}
	}

	public static void judgeBallAndStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount > 0) {
			OutputView.printBallAndStrikeCount(ballCount, strikeCount);
		}
	}
}
