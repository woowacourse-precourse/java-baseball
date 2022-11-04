package baseball;

public class Hint {
	public static void searchHint() {
		new ComparisonResult(User.userNums, Computer.computerNums);
		if (getRightAnswer()) {
			GameView.printEndGame();
			GameView.printRestartGame();
			return;
		}
		if (getNothing()) {
			hintNothing();
		}
		if (getBall()) {
			hintBall();
		}
		if (getStrike()) {
			hintStrike();
		}
	}

	private static boolean getRightAnswer() {
		return ComparisonResult.strikeCount == 3;
	}

	private static boolean getNothing() {
		return ComparisonResult.strikeCount == 0 && ComparisonResult.ballCount == 0;
	}

	private static boolean getBall() {
		return ComparisonResult.ballCount > 0;
	}

	private static boolean getStrike() {
		return ComparisonResult.strikeCount > 0;
	}

	private static void hintNothing() {
		GameView.printNothing();
	}

	private static void hintStrike() {
		GameView.printStrike(ComparisonResult.strikeCount);
	}

	private static void hintBall() {
		if (getStrike()) {
			GameView.printBallAndStrike(ComparisonResult.ballCount);
		} else {
			GameView.printBall(ComparisonResult.ballCount);
		}
	}
}
