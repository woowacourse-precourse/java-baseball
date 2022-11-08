package baseball.domain;

import baseball.domain.score.BallScore;
import baseball.domain.score.Nothing;
import baseball.domain.score.Score;
import baseball.domain.score.StrikeScore;

public enum BallStatus {
    BALL(new BallScore()),
    STRIKE(new StrikeScore()),
    NOTHING(new Nothing());
    
    private final Score score;
    
    BallStatus(Score score) {
        this.score = score;
    }
    
    public boolean isNothing() {
        return this == NOTHING;
    }
    
    public Score score() {
        return score;
    }
}
