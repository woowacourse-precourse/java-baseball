package baseball.model;

import java.util.*;

public class BaseBallMatchCounter {
    private final EnumMap countResult = new EnumMap(BaseBallResultType.class);
    public EnumMap<BaseBallResultType, Integer> getMatchResult(String homeRun, String input) {
        List<BaseBallResultType> baseBallResultTypes = new ArrayList<>();

        for (int i = 0; i < homeRun.length(); i++) {
            baseBallResultTypes.add(BaseBallResultType.findBallResultType(homeRun,input,i));
        }
        for (BaseBallResultType baseBallResultType : baseBallResultTypes){
            countResult.put(baseBallResultType, Collections.frequency(baseBallResultTypes,baseBallResultType));
        }

        return countResult;
    }

}
