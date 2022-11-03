package baseball.model.gameresult;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
	private final Map<ResultType, Integer> gameResult = new HashMap<>();

	public Map<ResultType, Integer> getGameResult() {
		return gameResult;
	}

	public void addSingleResult(ResultType resultType) {
		Integer resultCount = gameResult.computeIfAbsent(resultType, r -> 0);
		gameResult.put(resultType, resultCount + 1);
	}
}
