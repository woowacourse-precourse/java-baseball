package baseball;

public class Ball {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	private final int number;

	public Ball(final int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(final int number) {
		if (isOutOfRange(number)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfRange(final int number) {
		return MIN_NUMBER > number || number > MAX_NUMBER;
	}

	public BallStatus compareTo(final Ball ball) {
		if (equals(ball)) {
			return BallStatus.STRIKE;
		}
		return BallStatus.NOTHING;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Ball other = (Ball)obj;
		return this.number == other.number;
	}
}
