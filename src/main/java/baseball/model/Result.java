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
