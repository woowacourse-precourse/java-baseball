package baseball;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {
    private final Map<ThrowingType, Long> scoreTable;

    public Score(Map<ThrowingType, Long> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public boolean allMatch() {
        return scoreTable.keySet()
                .stream()
                .allMatch(ThrowingType.STRIKE::equals);
    }

    @Override
    public String toString() {
        return Stream.of(ThrowingType.BALL, ThrowingType.STRIKE)
                .filter(scoreTable::containsKey)
                .map(throwingType -> scoreTable.get(throwingType) + throwingType.toString())
                .collect(Collectors.collectingAndThen(Collectors.joining(" "),
                        this::nothingIfEmpty));
    }

    private String nothingIfEmpty(String str) {
        if (str.isEmpty()) {
            return ThrowingType.NOTHING.toString();
        }
        return str;
    }
}
