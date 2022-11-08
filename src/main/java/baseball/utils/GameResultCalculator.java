package baseball.utils;

import java.util.List;

import baseball.ball.BallNumbers;
import baseball.computer.Computer;
import baseball.game.Game;

public class GameResultCalculator {
	private final static int NUMBER_OF_BALLS = 3;

	public static Game calculateStrikeAndBallCount(BallNumbers playerBallNumbers) {
		int strikeCount = GameResultCalculator.calculateStrikeCount(playerBallNumbers);
		int ballCount = GameResultCalculator.calculateBallCount(playerBallNumbers);

		return Game.from(strikeCount, ballCount);
	}

	public static int calculateStrikeCount(BallNumbers ballNumbers) {
		int strikeCount = 0;

		for (int i = 0; i < NUMBER_OF_BALLS; i++) {
			int playerBallNumber = ballNumbers.getBallNumberByIndex(i);
			int answerBallNumber = Computer.getAnswerBallNumbers().getBallNumberByIndex(i);

			if (isStrike(playerBallNumber, answerBallNumber)) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	public static int calculateBallCount(BallNumbers ballNumbers) {
		int ballCount = 0;

		List<Integer> playerBallNumbers = ballNumbers.getAllBallNumber();
		List<Integer> answerBallNumbers = Computer.getAnswerBallNumbers().getAllBallNumber();

		for (int i = 0; i < NUMBER_OF_BALLS; i++) {
			if (!isStrike(playerBallNumbers.get(i), answerBallNumbers.get(i))
				&& isAnswerBallNumbersContainPlayerBallNumber(playerBallNumbers.get(i), answerBallNumbers)) {
				ballCount++;
			}
		}

		return ballCount;
	}

	private static boolean isStrike(int playerBallNumber, int answerBallNumber) {
		return playerBallNumber == answerBallNumber;
	}

	private static boolean isAnswerBallNumbersContainPlayerBallNumber(int playerBallNumber,
		List<Integer> answerBallNumber) {
		return answerBallNumber.contains(playerBallNumber);
	}

}
