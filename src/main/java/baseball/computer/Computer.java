package baseball.computer;

import baseball.ball.BallNumbers;
import baseball.program.Program;
import baseball.utils.RandomAnswerBallNumberGenerator;

public class Computer {
	private static BallNumbers answerBallNumbers;

	public static void init() {
		answerBallNumbers = setAnswerBallNumbers();
	}
	private static BallNumbers setAnswerBallNumbers() {
		return RandomAnswerBallNumberGenerator.generate();
	}

	public static BallNumbers getAnswerBallNumbers() {
		return answerBallNumbers;
	}

	public static void reInitIfProgramContinue() {
		if (Program.isProgramContinue()) {
			init();
		}
	}
}
