package baseball.domain;

import static baseball.domain.ConstVariable.THREE_STRIKE;

public class Result {
    private int ball;
    private int strike;

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void report(BallStatus status) {
        if (status.isBall()) {
            this.ball++;
        }
        if (status.isStrike()) {
            this.strike++;
        }
    }

    public boolean isGameOver() {
        return this.strike == THREE_STRIKE;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) return "낫싱";

        StringBuilder result = new StringBuilder();
        if (ball == 0 && strike > 0) {
            return result.append(strike).append("스트라이크").toString();
        }
        if (ball > 0) {
            result.append(ball).append("볼");
        }
        if (strike > 0) {
            result.append(" ").append(strike).append("스트라이크");
        }
        return result.toString();
    }
}
