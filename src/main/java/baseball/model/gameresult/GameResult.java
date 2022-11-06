package baseball.model.gameresult;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
	private static final int RESULT_MAX_COUNT = 3;

	private final Map<SingleResultType, Integer> gameResult = new LinkedHashMap<>();

	public GameResult() {
		for (SingleResultType singleResultType : SingleResultType.values()) {
			gameResult.put(singleResultType, 0);
		}
	}

	public void addSingleResult(SingleResultType singleResultType) {
		Integer resultCount = gameResult.computeIfAbsent(singleResultType, r -> 0);
		gameResult.put(singleResultType, resultCount + 1);
	}

	public int countSingleResult(SingleResultType singleResultType) {
		return gameResult.getOrDefault(singleResultType, 0);
	}

	public boolean isEndCondition() {
		return countSingleResult(SingleResultType.STRIKE) == RESULT_MAX_COUNT;
	}

	// FIXME : 복잡한 toString() 역할 분담 필요
	@Override
	public String toString() {
		if (isNothing()) {
			return "낫싱";
		}

		StringBuilder sb = getResultsCount();
		return sb.toString().trim();
	}

	private boolean isNothing() {
		return gameResult.get(SingleResultType.NOTHING) == RESULT_MAX_COUNT;
	}

	private StringBuilder getResultsCount() {
		StringBuilder sb = new StringBuilder();
		for (SingleResultType singleResultType : gameResult.keySet()) {
			if (singleResultType == SingleResultType.NOTHING) {
				continue;
			}

			appendBySingleResult(sb, singleResultType);
		}
		return sb;
	}

	private void appendBySingleResult(StringBuilder sb, SingleResultType singleResultType) {
		Integer count = gameResult.get(singleResultType);
		if (count == 0) {
			return;
		}

		sb.append(count).append(singleResultType.getMessage()).append(" ");
	}
}
