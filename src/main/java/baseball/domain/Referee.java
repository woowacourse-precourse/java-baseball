package baseball.domain;

import baseball.domain.score.BallScore;
import baseball.domain.score.Score;
import baseball.domain.score.StrikeScore;

import java.util.List;

public class Referee {
    private Score strike;
    private Score ball;
    
    public Referee() {
        strike = new StrikeScore();
        ball = new BallScore();
    }
    
    public void decide(final List<BallStatus> ballStatuses) {
        ballStatuses.forEach(this::detailDecide);
    }
    
    private void detailDecide(final BallStatus ballStatus) {
        if (isStrike(ballStatus)) {
            this.strike = strike.increase();
        }
        
        if (isBall(ballStatus)) {
            this.ball = ball.increase();
        }
    }
    
    private boolean isStrike(final BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }
    
    private boolean isBall(final BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }
    
    public boolean isBaseBallGameEnd() {
        return strike.isGameEnd();
    }
    
    public Score strike() {
        return strike;
    }
    
    public Score ball() {
        return ball;
    }
    
    @Override
    public String toString() {
        return "Referee{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}
