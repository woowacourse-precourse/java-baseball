package baseball.model;

import baseball.BallNumbers;

import java.util.*;

public enum BaseBallHitsType {
    STRIKE("스트라이크", 0),
    BALL("볼", 1),
    NOTING("낫싱", -1);

    private final String ballResultType;

    private final Integer ballRules;

    BaseBallHitsType(String ballResultType, Integer ballRules) {
        this.ballResultType = ballResultType;
        this.ballRules = ballRules;
    }

    public static Map<BaseBallHitsType, Integer> hitsTypeMap(BallNumbers homeRun, BallNumbers hits) {
        EnumMap<BaseBallHitsType, Integer> countResult = new EnumMap<>(BaseBallHitsType.class);
        List<BaseBallHitsType> baseBallTypes = ballHitTypes(homeRun, hits);

        for (BaseBallHitsType hitType : baseBallTypes) {
            countResult.put(hitType, Collections.frequency(baseBallTypes, hitType));
        }

        return countResult;
    }

    private static List<BaseBallHitsType> ballHitTypes(BallNumbers homeRun, BallNumbers hits) {
        List<BaseBallHitsType> baseBallResultTypes = new ArrayList<>();

        for (int i = 0; i < homeRun.size(); i++) {
            baseBallResultTypes.add(BaseBallHitsType.findBallHitType(homeRun, hits, i));
        }
        return baseBallResultTypes;
    }

    public static BaseBallHitsType findBallHitType(BallNumbers homeRun, BallNumbers hits, int round) {
        return Arrays.stream(values())
                .filter(baseBallType -> baseBallType.ballRules == homeRun.roundResult(round, hits.roundNumber(round)))
                .findAny()
                .orElseThrow();
    }

    public String getBallResultType() {
        return ballResultType;
    }

    public Integer getBallRules() {
        return ballRules;
    }

}
