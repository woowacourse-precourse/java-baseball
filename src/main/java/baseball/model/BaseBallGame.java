package baseball.model;

import java.util.*;


public class BaseBallGame {

    public Map<BaseBallHitsType, Integer> baseBallHitsTypeMap(List<Character> tempHomeRun, BallNumbers hits) {
        EnumMap<BaseBallHitsType, Integer> hitTypeResult = new EnumMap<>(BaseBallHitsType.class);
        List<BaseBallHitsType> baseBallTypes = ballHitTypes(homeRun(tempHomeRun), hits);

        for (BaseBallHitsType hitType : baseBallTypes) {
            hitTypeResult.put(hitType, Collections.frequency(baseBallTypes, hitType));
        }

        return hitTypeResult;
    }

    private List<BaseBallHitsType> ballHitTypes(BallNumbers homeRun, BallNumbers hits) {
        List<BaseBallHitsType> baseBallResultTypes = new ArrayList<>();

        for (int i = 0; i < homeRun.size(); i++) {
            baseBallResultTypes.add(BaseBallHitsType.findBallHitType(homeRun, hits, i));
        }
        return baseBallResultTypes;
    }

    private BallNumbers homeRun(List<Character> ballNumbers) {
        return new BallNumbers(ballNumbers);
    }
}
