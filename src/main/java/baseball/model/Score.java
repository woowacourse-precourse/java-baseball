package baseball.model;

public class Score {
    int ball;
    int strike;

    public Score () {
        ball = 0;
        strike = 0;
    }

    public Hint getScoreHint() {
        if (isNothing()) return Hint.NOTHING;
        if (isBothBallAndStrike()) return Hint.BALL_AND_STRIKE;
        if (isOnlyStrikeAndNotBall()) return Hint.ONLY_STRIKE;
        if (isOnlyBallAndNotStrike()) return Hint.ONLY_BALL;
        return null;
    }

    public Boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public Boolean isOnlyBallAndNotStrike() {
        return ball != 0 && strike == 0;
    }

    public Boolean isOnlyStrikeAndNotBall() {
        return ball == 0 && strike != 0;
    }

    public Boolean isBothBallAndStrike() {
        return ball != 0 && strike != 0;
    }

    public void countBall() {
        this.ball++;
    }

    public void countStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}