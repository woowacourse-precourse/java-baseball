package baseball.domain;

import java.util.List;

public class Referee {
    private BallStatusScore strike;
    private BallStatusScore ball;
    
    public Referee() {
        strike = new BallStatusScore();
        ball = new BallStatusScore();
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
    
    public boolean isEnd() {
        return strike.isGameEnd();
    }
}
