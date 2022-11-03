package baseball;

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
        if (status == BallStatus.BALL) {
            this.ball++;
        }
        if (status == BallStatus.STRIKE) {
            this.strike++;
        }
    }

    public boolean isGameOver() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) return "낫싱";

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append("볼");
        }
        if (ball == 0 && strike > 0) {
            return result.append(strike).append("스트라이크").toString();
        }
        if (strike > 0) {
            return result.append(' ').append(strike).append("스트라이크").toString();
        }
        return result.toString();
    }
}
