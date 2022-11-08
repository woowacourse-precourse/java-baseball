package baseball;

public class Ball {

	private final BallNumber number;
	
	private final int position;

	public Ball(final int number, final int position) {
		this.number = new BallNumber(number);
		this.position = position;
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

	private boolean matchNumber(final Ball other) {
		return this.number.equals(other.number);
	}

	private boolean matchPosition(final Ball other) {
		return this.position == other.position;
	}
}
