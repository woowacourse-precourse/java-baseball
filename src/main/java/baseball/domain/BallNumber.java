package baseball.domain;

public class BallNumber {

	private final int ballNumber;

	public BallNumber(int ballNumber) {
		validateBallNumber(ballNumber);
		this.ballNumber = ballNumber;
	}

	private void validateBallNumber(int ballNumber) {
		if (ballNumber < Constants.MIN_NUMBER || ballNumber > Constants.MAX_NUMBER) {
			throw new IllegalArgumentException(Constants.BALL_NUMBER_ERR_MSG);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!obj.getClass().isAssignableFrom(BallNumber.class)) {
			return false;
		}
		BallNumber otherBallNumber = (BallNumber) obj;
		return this.ballNumber == otherBallNumber.ballNumber;
	}
}
