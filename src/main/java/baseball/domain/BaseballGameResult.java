package baseball.domain;

import java.util.Objects;

public class BaseballGameResult {
    private final int ball;
    private final int strike;

    public BaseballGameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean is3Strike() {
        return strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballGameResult that = (BaseballGameResult) o;
        return ball == that.ball && strike == that.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
