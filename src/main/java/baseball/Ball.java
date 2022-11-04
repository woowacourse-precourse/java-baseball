package baseball;

import java.util.Objects;

public class Ball {
	private final int number;
	private final int location;

	public Ball(int number, int location) {
		this.number = number;
		this.location = location;
	}

	public CompareResult compare(Ball ballToCompare) {
		if (this.equals(ballToCompare)) {
			return CompareResult.STRIKE;
		}
		if (ballToCompare.isSameNumber(number) && ballToCompare.isDifferentLocation(location)) {
			return CompareResult.BALL;
		}
		return CompareResult.BALL;
	}

	private boolean isDifferentLocation(int location) {
		return this.location != location;
	}

	private boolean isSameNumber(int number) {
		return this.number == number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number && location == ball.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, location);
	}
}
