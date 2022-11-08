package baseball.domain;

public class PlayResult {

	int ballCount;
	int strikeCount;

	public PlayResult(Integer ballCount, Integer strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	public boolean isEnd() {
		return this.strikeCount == Constants.NUMBER_SIZE;
	}

	@Override
	public String toString() {
		if (ballCount == 0 && strikeCount == 0) {
			return Constants.NOTHING_MSG;
		}
		StringBuilder messageBuilder = new StringBuilder();
		if (ballCount > 0) {
			messageBuilder.append(ballCount);
			messageBuilder.append(Constants.BALL_MSG);
			messageBuilder.append(" ");
		}
		if (strikeCount > 0) {
			messageBuilder.append(strikeCount);
			messageBuilder.append(Constants.STRIKE_MSG);
		}
		return messageBuilder.toString().trim();
	}
}
