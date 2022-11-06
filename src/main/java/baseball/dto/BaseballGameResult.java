package baseball.dto;

public class BaseballGameResult {
    private final Integer strike;
    private final Integer ball;

    public BaseballGameResult(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
