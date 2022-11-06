package baseball.model.gameresult;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
	private static final int RESULT_MAX_COUNT = 3;

	private final List<SingleResultType> gameResults = new ArrayList<>();

	public List<SingleResultType> getGameResults() {
		return gameResults;
	}

	public void addSingleResult(SingleResultType singleResultType) {
		if (singleResultType == SingleResultType.MISS) {
			return;
		}

		gameResults.add(singleResultType);
	}

	public int countSingleResult(SingleResultType singleResultType) {
		return (int) gameResults.stream()
			.filter(r -> r == singleResultType)
			.count();
	}

	public boolean isEndCondition() {
		return countSingleResult(SingleResultType.STRIKE) == RESULT_MAX_COUNT;
	}
}
