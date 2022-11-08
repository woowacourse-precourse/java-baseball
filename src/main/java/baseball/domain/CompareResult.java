package baseball.domain;

import static baseball.domain.BallStatus.STRIKE;
import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareResult {

    private static final int MAX_STATUS_SIZE = 3;

    private static final int INITIAL_STATUS_COUNT = 1;

    private final Map<BallStatus, Integer> occurrences;

    public CompareResult() {
        this.occurrences = new HashMap<>();
    }

    public void addResult(BallStatus ballStatus) {
        occurrences.merge(ballStatus, INITIAL_STATUS_COUNT, Integer::sum);
    }

    public int getStrikes() {
        return occurrences.getOrDefault(STRIKE, 0);
    }

    public int getBalls() {
        return occurrences.getOrDefault(BALL, 0);
    }

    public boolean isAllNothing() {
        return occurrences.containsKey(NOTHING)
            && occurrences.get(NOTHING) == MAX_STATUS_SIZE;
    }

    public boolean isAllStrikes() {
        return occurrences.containsKey(STRIKE)
            && occurrences.get(STRIKE) == MAX_STATUS_SIZE;
    }

    public List<String> getResults() {
        if (isAllNothing()) {
            return List.of(NOTHING.getStatus());
        }
        return occurrences.keySet()
            .stream()
            .filter(BallStatus::isNotNothing)
            .sorted(Comparator.comparing(BallStatus::getStatus))
            .map(this::formatStatus)
            .collect(Collectors.toList());
    }

    private String formatStatus(BallStatus status) {
        return String.format("%d%s",
            occurrences.get(status), status.getStatus());
    }
}
