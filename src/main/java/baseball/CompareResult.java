package baseball;

import static baseball.BallStatus.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareResult {

	private final Map<BallStatus, Integer> occurrences;

	public CompareResult() {
		this.occurrences = new HashMap<>();
	}

	public void addResult(BallStatus ballStatus) {
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

	public boolean isAllStrikes() {
		return occurrences.containsKey(STRIKE)
			&& occurrences.get(STRIKE) == 3;
	}

	public List<String> getResults() {
		if (isAllNothing()) {
			return List.of(NOTHING.getStatus());
		}
		return occurrences.keySet()
			.stream()
			.filter(BallStatus::isStrikeOrBall)
			.sorted(Comparator.comparing(BallStatus::getStatus))
			.map(this::formatStatus)
			.collect(Collectors.toList());
	}

	private String formatStatus(BallStatus status) {
		String count = String.valueOf(occurrences.get(status));
		return String.join("", count, status.getStatus());
	}
}
