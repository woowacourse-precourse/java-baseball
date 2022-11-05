package baseball.model;

import java.util.Objects;

public class Result {

    private final int ball;
    private final int strike;
    private final int out;

    public Result(int ball, int strike, int out) {
        this.ball = ball;
        this.strike = strike;
        this.out = out;
    }

    public Result increaseBallCount() {
        return new Result(ball + 1, strike, out);
    }

    public Result increaseStrikeCount() {
        return new Result(ball, strike + 1, out);
    }

    public Result increaseOutCount() {
        return new Result(ball, strike, out + 1);
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean isGameEnd() {
        return strike == Balls.NUMBER_OF_BALLS;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Result result = (Result) obj;
        return ball == result.ball && strike == result.strike && out == result.out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike, out);
    }
}
