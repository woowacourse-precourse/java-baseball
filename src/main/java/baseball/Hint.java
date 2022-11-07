package baseball;

public class Hint {
	private Hint() {
	}

	public static void search() {
		new ResultOfComparison(User.userNums, Computer.computerNums);
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
		return ResultOfComparison.strikeCount == 0 && ResultOfComparison.ballCount == 0;
	}

	private static boolean isBall() {
		return ResultOfComparison.ballCount > 0;
	}

	private static boolean isStrike() {
		return ResultOfComparison.strikeCount > 0;
	}

	public static boolean isRightAnswer() {
		return ResultOfComparison.strikeCount == 3;
	}

	private static void hintNothing() {
		GameView.printNothing();
	}

	private static void hintBall() {
		if (isStrike()) {
			GameView.printBallAndStrike(ResultOfComparison.ballCount);
		} else {
			GameView.printBall(ResultOfComparison.ballCount);
		}
	}

	private static void hintStrike() {
		GameView.printStrike(ResultOfComparison.strikeCount);
	}

	private static void hintRightAnswer() {
		GameView.printEndGame();
		GameView.printRestartInstruction();
	}
}
