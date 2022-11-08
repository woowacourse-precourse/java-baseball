package baseball.model;

public class GameResult {
    private final int ball;
    private final int strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isAllStrike() {
        return (strike == 3);
    }

    public boolean isNothing() {
        return (ball + strike == 0);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
