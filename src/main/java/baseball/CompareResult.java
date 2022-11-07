package baseball;

import static baseball.BallStatus.*;

import java.util.HashMap;
import java.util.Map;

public class CompareResult {

	private final Map<BallStatus, Integer> occurrences;

	public CompareResult() {
		this.occurrences = new HashMap<>();
	}

	public void addStatus(BallStatus ballStatus) {
		occurrences.merge(ballStatus, 1, Integer::sum);
	}

	public int getStrikes() {
		return occurrences.getOrDefault(STRIKE, 0);
	}

	public int getBalls() {
		return occurrences.getOrDefault(BALL, 0);
	}

	public boolean isAllNothing() {
		return occurrences.containsKey(NOTHING)
		&& occurrences.get(NOTHING) == 3;
	}
}
