package baseball.domain;

public class BaseballGameResult {
	private final int numberOfStrike;
	private final int numberOfBall;

	public BaseballGameResult(int numberOfStrike, int numberOfBall) {
		this.numberOfStrike = numberOfStrike;
		this.numberOfBall = numberOfBall;
	}

	public int getNumberOfStrike() {
		return numberOfStrike;
	}

	public int getNumberOfBall() {
		return numberOfBall;
	}

	@Override
	public String toString() {
		return "BaseballGameResult{" +
			"numberOfStrike=" + numberOfStrike +
			", numberOfBall=" + numberOfBall +
			'}';
	}
}
