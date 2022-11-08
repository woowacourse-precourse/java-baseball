package baseball.domain;

public class PlayResult {

	int ballCount;
	int strikeCount;

	public PlayResult(Integer ballCount, Integer strikeCount) {
		this.ballCount = ballCount;
		this.strikeCount = strikeCount;
	}

	@Override
	public String toString() {
		if (ballCount == 0 && strikeCount == 0) {
			return Constants.MSG_NOTHING;
		}
		StringBuilder messageBuilder = new StringBuilder();
		if (ballCount > 0) {
			messageBuilder.append(ballCount);
			messageBuilder.append(Constants.MSG_BALL);
			messageBuilder.append(" ");
		}
		if (strikeCount > 0) {
			messageBuilder.append(strikeCount);
			messageBuilder.append(Constants.MSG_STRIKE);
		}
		return messageBuilder.toString().trim();
	}
}
