package baseball.domain;

public class BallNumber {

	private final int ballNumber;

	public BallNumber(int ballNumber) {
		validateBallNumber(ballNumber);
		this.ballNumber = ballNumber;
	}

	private void validateBallNumber(int ballNumber) {
		if (ballNumber < Constants.MIN_NUMBER || ballNumber > Constants.MAX_NUMBER) {
			throw new IllegalArgumentException("야구공의 숫자는 1~9 사이의 숫자입니다.");
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
