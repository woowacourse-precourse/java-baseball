package baseball.model;

public class GameResult {
    private Integer strike;
    private Integer ball;

    public GameResult(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }
}