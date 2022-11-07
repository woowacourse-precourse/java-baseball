package baseball.domain;

import baseball.status.Constants;

public class BaseballDto {

    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addBallCount() {
        ball += Constants.COUNT.getNumber();
    }

    public void addStrikeCount() {
        strike += Constants.COUNT.getNumber();
    }

    public void initializeBaseBallDto() {
        ball = Constants.ZERO_COUNT.getNumber();
        strike = Constants.ZERO_COUNT.getNumber();
    }

    public boolean isBallExist() {
        return ball > Constants.ZERO_COUNT.getNumber();
    }

    public boolean isStrikeExist() {
        return strike > Constants.ZERO_COUNT.getNumber();
    }
}
