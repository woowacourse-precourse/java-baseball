package baseball.model;

import java.util.*;

public class BaseBallMatchCounter {
    private final EnumMap countResult = new EnumMap(BaseBallHitsType.class);
    public EnumMap<BaseBallHitsType, Integer> getMatchResult(String homeRun, String input) {
        List<BaseBallHitsType> baseBallResultTypes = new ArrayList<>();

        for (int i = 0; i < homeRun.length(); i++) {
            baseBallResultTypes.add(BaseBallHitsType.findBallType(homeRun,input,i));
        }
        for (BaseBallHitsType baseBallResultType : baseBallResultTypes){
            countResult.put(baseBallResultType, Collections.frequency(baseBallResultTypes,baseBallResultType));
        }

        return countResult;
    }

}
