package baseball.game;

import baseball.ball.BallResult;

public class GameResult {
    private final int WIN_CONDITION = 3;
    private static final int ZERO = 0;
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void plusScore(BallResult ballResult) {
        if (ballResult.isBall()) {
            ball++;
        }
        if (ballResult.isStrike()) {
            strike++;
        }
    }

    public boolean isWinCondition() {
        return this.strike == WIN_CONDITION;
    }

    public boolean isBallScoreValid() {
        return this.ball > ZERO;
    }

    public boolean isStrikeScoreValid() {
        return this.strike > ZERO;
    }

    public boolean isNoScore() {
        return this.strike == ZERO && this.ball == ZERO;
    }
}
