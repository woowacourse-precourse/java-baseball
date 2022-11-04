package baseball.model;

public class GameResult {
    private final Integer ball;
    private final Integer strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean playerWin() {
        return (strike == 3);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
