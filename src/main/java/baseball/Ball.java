package baseball;

public class Ball {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	private final int number;
	
	private final int position;

	public Ball(final int number, int position) {
		validateNumber(number);
		this.number = number;
		this.position = position;
	}

	private void validateNumber(final int number) {
		if (isOutOfRange(number)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isOutOfRange(final int number) {
		return MIN_NUMBER > number || number > MAX_NUMBER;
	}

	public BallStatus compareTo(final Ball other) {
		if (this.equals(other)) {
			return BallStatus.STRIKE;
		}
		if (this.matchNumber(other)) {
			return BallStatus.BALL;
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
		return matchNumber(other)
			&& matchPosition(other);
	}

	private boolean matchNumber(Ball other) {
		return this.number == other.number;
	}

	private boolean matchPosition(Ball other) {
		return this.position == other.position;
	}


}
