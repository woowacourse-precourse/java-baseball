package baseball.domain;

public class ScoreBoard {
    private static final int THREE_STRIKE = 3;
    private boolean threeStrike;
    private int ball;
    private int strike;

    public void setScoreBoard(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
        if (strike == THREE_STRIKE) {
            this.threeStrike = true;
        }
    }

    public boolean isThreeStrike() {
        return threeStrike;
    }

    public void setThreeStrike(boolean threeStrike) {
        this.threeStrike = threeStrike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
