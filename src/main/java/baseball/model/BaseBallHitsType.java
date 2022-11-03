package baseball.model;

import baseball.model.hitrule.BallRules;
import baseball.model.hitrule.HitsDiscriminatoryRules;
import baseball.model.hitrule.NothingRule;
import baseball.model.hitrule.StrikeRules;

import java.util.Arrays;

public enum BaseBallHitsType {
    STRIKE("스트라이크", new StrikeRules()),
    BALL("볼", new BallRules()),
    NOTING("낫싱", new NothingRule());

    private final String ballResultType;

    private final HitsDiscriminatoryRules ballRules;

    BaseBallHitsType(String ballResultType, HitsDiscriminatoryRules ballRules) {
        this.ballResultType = ballResultType;
        this.ballRules = ballRules;
    }
    public static BaseBallHitsType findBallType(String homeRun, String hits, int index) {
        return Arrays.stream(values())
                .filter(baseBallType -> baseBallType.discriminateBallType(homeRun, hits, index))
                .findAny()
                .orElseThrow();
    }
    private boolean discriminateBallType(String homeRun, String input, int index) {
        return this.ballRules.isType(homeRun, input, index);
    }
}
