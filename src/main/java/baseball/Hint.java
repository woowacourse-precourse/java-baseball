package baseball;

public class Hint {
	public static void searchHint() {
		new ComparisonResult(User.userNums, Computer.computerNums);
		if (isNothing()) {
			hintNothing();
		}
		if (isBall()) {
			hintBall();
		}
		if (isStrike()) {
			hintStrike();
		}
		if (isRightAnswer()) {
			hintRightAnswer();
		}
	}

	private static boolean isNothing() {
		return ComparisonResult.strikeCount == 0 && ComparisonResult.ballCount == 0;
	}

	private static boolean isBall() {
		return ComparisonResult.ballCount > 0;
	}

	private static boolean isStrike() {
		return ComparisonResult.strikeCount > 0;
	}

	public static boolean isRightAnswer() {
		return ComparisonResult.strikeCount == 3;
	}

	private static void hintNothing() {
		GameView.printNothing();
	}


	private static void hintBall() {
		if (isStrike()) {
			GameView.printBallAndStrike(ComparisonResult.ballCount);
		} else {
			GameView.printBall(ComparisonResult.ballCount);
		}
	}

	private static void hintStrike() {
		GameView.printStrike(ComparisonResult.strikeCount);
	}

	private static void hintRightAnswer() {
		GameView.printEndGame();
		GameView.printRestartInstruction();
	}
}
