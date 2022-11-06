package baseball.object;

public class GameResult {
    private Integer ball;
    private Integer strike;

    public GameResult(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public Boolean isGameEnd() {
        return strike == 3;
    }
}
