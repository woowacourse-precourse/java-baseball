package baseball.model.gameresult;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
	private static final int RESULT_MAX_COUNT = 3;

	private final List<SingleResultType> gameResults = new ArrayList<>();

	public void addSingleResult(SingleResultType singleResultType) {
		if (singleResultType == SingleResultType.MISS) {
			return;
		}

		gameResults.add(singleResultType);
	}

	public int countSingleResult(SingleResultType singleResultType) {
		return (int)gameResults.stream()
			.filter(r -> r == singleResultType)
			.count();
	}

	public boolean isEndCondition() {
		return countSingleResult(SingleResultType.STRIKE) == RESULT_MAX_COUNT;
	}

	public String format() {
		if (isNothing()) {
			return "낫싱";
		}

		StringBuilder sb = getResultsCount();
		return sb.toString().trim();
	}

	private boolean isNothing() {
		return gameResults.isEmpty();
	}

	private StringBuilder getResultsCount() {
		StringBuilder sb = new StringBuilder();
		for (SingleResultType singleResultType : SingleResultType.values()) {
			appendBySingleResult(sb, singleResultType);
		}
		return sb;
	}

	private void appendBySingleResult(StringBuilder sb, SingleResultType singleResultType) {
		Integer count = countSingleResult(singleResultType);
		if (count == 0) {
			return;
		}

		sb.append(count).append(singleResultType.getMessage()).append(" ");
	}
}
