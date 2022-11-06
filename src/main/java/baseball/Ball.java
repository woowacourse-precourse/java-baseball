package baseball;

public class Ball {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	public Ball(final int number) {
		validateNumber(number);
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
		return BallStatus.NOTHING;
	}
}
