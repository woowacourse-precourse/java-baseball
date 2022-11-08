package baseball.domain;

public class Baseball {

    private final int strike;
    private final int ball;

    public Baseball(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return toUnitExpression(ball, "볼");
        } else if (ball == 0) {
            return toUnitExpression(strike, "스트라이크");
        } else {
            return toUnitExpression(ball, "볼")
                + " "
                + toUnitExpression(strike, "스트라이크");
        }
    }

    private String toUnitExpression(final int number, final String unit) {
        return number + unit;
    }

}
