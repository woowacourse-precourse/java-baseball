package baseball.dto;

public class BallCountDto {
    private int strike;
    private int ball;

    public BallCountDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
