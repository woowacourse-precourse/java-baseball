package baseball;

public class Hint {
	public static void searchHint() {
		new ComparisonResult(User.userNums, Computer.computerNums);
		if (getNothing()) {
			hintNothing();
		}
		if (getBall()) {
			hintBall();
		}
		if (getStrike()) {
			hintStrike();
		}
		if (getRightAnswer()) {
			hintCorrect();
		}
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

	public static boolean getRightAnswer() {
		return ComparisonResult.strikeCount == 3;
	}

	private static void hintNothing() {
		GameView.printNothing();
	}


	private static void hintBall() {
		if (getStrike()) {
			GameView.printBallAndStrike(ComparisonResult.ballCount);
		} else {
			GameView.printBall(ComparisonResult.ballCount);
			GameView.printNewLine();
		}
	}

	private static void hintStrike() {
		GameView.printStrike(ComparisonResult.strikeCount);
		GameView.printNewLine();
	}

	private static void hintCorrect() {
		GameView.printEndGame();
		GameView.printRestartInstruction();
	}
}
