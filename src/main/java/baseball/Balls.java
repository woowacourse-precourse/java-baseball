package baseball;

import java.util.List;
import java.util.Objects;

public class Balls {
	private List<Ball> balls;

	public Balls(int firstNumber, int secondNumber, int thirdNumber) {
		Ball firstBall = new Ball(firstNumber, 0);
		Ball secondBall = new Ball(secondNumber, 1);
		Ball thirdBall = new Ball(thirdNumber, 2);

		balls = List.of(firstBall, secondBall, thirdBall);
	}

	public Balls(String consoleInput) {
		this(
			Character.getNumericValue(consoleInput.charAt(0)),
			Character.getNumericValue(consoleInput.charAt(1)),
			Character.getNumericValue(consoleInput.charAt(2))
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
