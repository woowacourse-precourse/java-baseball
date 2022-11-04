package baseball.dto;

public class ScoreResult {
    private int strike;
    private int ball;

    private ScoreResult(Builder builder) {
        this.strike = builder.strike;
        this.ball = builder.ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public static class Builder {
        private int strike;
        private int ball;

        public Builder setStrike(int strike) {
            this.strike = strike;
            return this;
        }

        public Builder setBall(int ball) {
            this.ball = ball;
            return this;
        }

        public ScoreResult build() {
            return new ScoreResult(this);
        }
    }
}
