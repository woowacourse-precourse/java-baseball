package baseball.model.gameresult;

public class GameResultFormatter {

	private final GameResult gameResult;

	public GameResultFormatter(GameResult gameResult) {
		this.gameResult = gameResult;
	}

	public String format() {
		if (isNothing()) {
			return "낫싱";
		}

		StringBuilder sb = getResultsCount();
		return sb.toString().trim();
	}

	private boolean isNothing() {
		return gameResult.getGameResults().isEmpty();
	}

	private StringBuilder getResultsCount() {
		StringBuilder sb = new StringBuilder();
		for (SingleResultType singleResultType : SingleResultType.values()) {
			appendBySingleResult(sb, singleResultType);
		}
		return sb;
	}

	private void appendBySingleResult(StringBuilder sb, SingleResultType singleResultType) {
		Integer count = gameResult.countSingleResult(singleResultType);
		if (count == 0) {
			return;
		}

		sb.append(count).append(singleResultType.getMessage()).append(" ");
	}
}
