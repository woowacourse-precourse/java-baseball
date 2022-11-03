package baseball.model;

import java.util.*;

public class BaseBallMatchCounter {
    private final EnumMap<BaseBallHitsType, Integer> countResult = new EnumMap<>(BaseBallHitsType.class);

    public Map<BaseBallHitsType, Integer> getMatchResult(String homeRun, String hits) {
        List<BaseBallHitsType> baseBallResultTypes = new ArrayList<>();

        for (int i = 0; i < homeRun.length(); i++) {
            baseBallResultTypes.add(BaseBallHitsType.findBallType(homeRun, hits, i));
        }
        for (BaseBallHitsType baseBallResultType : baseBallResultTypes) {
            countResult.put(baseBallResultType, Collections.frequency(baseBallResultTypes, baseBallResultType));
        }

        return countResult;
    }

}
