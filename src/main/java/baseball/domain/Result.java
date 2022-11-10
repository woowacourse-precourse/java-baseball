package baseball.domain;

import java.util.Objects;

public class Result {
    private int ball = 0;
    private int strike = 0;

    public Result() {

    }
    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String countBall() {
        if (ball == 0) {
            return "";
        }
        return ball + "볼";
    }

    public String countStrike() {
        if (strike == 0) {
            return "";
        }
        return strike+"스트라이크";
    }

    public String toString() {
        String out = String.join(" ",countBall(),countStrike());
        if (out.isBlank()) {
            return "낫싱";
        }
        return out.trim();
    }

    public void report(Judgement judgement) {
        if (judgement.isStrike()) {
            strike += 1;
        }
        if (judgement.isBall()) {
            ball += 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return ball == result.ball && strike == result.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
