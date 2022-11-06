package baseball;

import static baseball.BallStatus.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayResult {

	private final Map<BallStatus, Integer> occurrences;

	public PlayResult() {
		this.occurrences = new HashMap<>();
	}

	public void addStatus(BallStatus ballStatus) {
		occurrences.merge(ballStatus, 1, Integer::sum);
	}

	public String getResult() {
		if (isAllNothing()) {
			return NOTHING.getStatus();
		}
		return occurrences.keySet()
			.stream()
			.filter(BallStatus::isStrikeOrBall)
			.map(this::formatStatus)
			.collect(Collectors.joining(" "));
	}

	private boolean isAllNothing() {
		return occurrences.get(NOTHING) == 3;
	}

	private String formatStatus(BallStatus status) {
		String count = String.valueOf(occurrences.get(status));
		return String.join("", count, status.getStatus());
	}
}
