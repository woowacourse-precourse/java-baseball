package baseball.dto;

public class ScoreResult {
    private int strike;
    private int ball;
    private ScoreResultType scoreResultType;

    private ScoreResult(Builder builder) {
        this.strike = builder.strike;
        this.ball = builder.ball;
        scoreResultType = initializeType();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public ScoreResultType getScoreResultType() {
        return scoreResultType;
    }

    private ScoreResultType initializeType() {
        if (threeStrike()) {
            return ScoreResultType.ALL_STRIKE;
        } else if (ballAndStrike()) {
            return ScoreResultType.BALL_STRIKE;
        } else if (onlyStrike()) {
            return ScoreResultType.STRIKE;
        } else if (onlyBall()) {
            return ScoreResultType.BALL;
        }
        return ScoreResultType.NOTHING;
    }

    private boolean onlyBall() {
        return ball > 0;
    }

    private boolean onlyStrike() {
        return strike > 0;
    }

    private boolean ballAndStrike() {
        return strike > 0 && ball > 0;
    }

    private boolean threeStrike() {
        return strike == 3;
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
