package baseball.baseballgame.balls;

import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BallReport {
    public static final int DEFAULT_VALUE = 0;
    public static final int ADD_COUNT = 1;
    private final EnumMap<JudgementType, Integer> ballReport;

    public BallReport() {
        ballReport = JudgementType.creatEnumMap();
    }

    public void add(JudgementType judgementType) {
        ballReport.putIfAbsent(judgementType, DEFAULT_VALUE);
        ballReport.put(judgementType, ballReport.get(judgementType) + ADD_COUNT);
    }

    public List<Integer> reportToList() {
        return ballReport.keySet().stream()
                .map(judgementType -> ballReport.getOrDefault(judgementType, DEFAULT_VALUE))
                .collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallReport)) {
            return false;
        }
        BallReport that = (BallReport) o;
        return Objects.equals(ballReport, that.ballReport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballReport);
    }
}
