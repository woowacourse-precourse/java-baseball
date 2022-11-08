package baseball.model;

import java.util.*;

public enum BaseBallHitsType {
    BALL("볼 ", 1),
    STRIKE("스트라이크 ", 3),
    NOTING("낫싱 ", -1);

    private final String ballResultType;

    private final Integer ballJudgement;

    BaseBallHitsType(String ballResultType, Integer ballJudgement) {
        this.ballResultType = ballResultType;
        this.ballJudgement = ballJudgement;
    }

    public static BaseBallHitsType findBallHitType(BallNumbers homeRun, BallNumbers hits, int round) {
        return Arrays.stream(values())
                .filter(baseBallType -> baseBallType.getBallJudgement() == homeRun.roundResult(round, hits.roundNumber(round)))
                .findAny()
                .orElseThrow();
    }

    public String hitType() {
        return ballResultType;
    }

    public Integer getBallJudgement() {
        return ballJudgement;
    }

}
