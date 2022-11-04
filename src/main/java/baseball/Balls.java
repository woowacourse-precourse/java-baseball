package baseball;

import java.util.List;
import java.util.Objects;

public class Balls {
	public static final int FIRST = 0;
	public static final int MIDDLE = 1;
	public static final int LAST = 2;

	private List<Ball> balls;

	public Balls(int firstNumber, int middleNumber, int lastNumber) {
		Ball firstBall = new Ball(firstNumber, FIRST);
		Ball secondBall = new Ball(middleNumber, MIDDLE);
		Ball thirdBall = new Ball(lastNumber, LAST);

		balls = List.of(firstBall, secondBall, thirdBall);
	}

	public Balls(String consoleInput) {
		this(
			Character.getNumericValue(consoleInput.charAt(FIRST)),
			Character.getNumericValue(consoleInput.charAt(MIDDLE)),
			Character.getNumericValue(consoleInput.charAt(LAST))
		);
	}

	public GameResult getGameResult(Balls otherBalls) {
		GameResult gameResult = new GameResult();
		for (Ball ball : balls) {
			otherBalls.compare(ball, gameResult);
		}
		return gameResult;
	}

	private void compare(Ball ball, GameResult gameResult) {
		for (Ball ballToCompare : balls) {
			CompareResult compareResult = ball.compare(ballToCompare);
			if (compareResult.isStike()) {
				gameResult.addStrike();
			}
			if (compareResult.isBall()) {
				gameResult.addBall();
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Balls balls1 = (Balls)o;
		return Objects.equals(balls, balls1.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}
}
