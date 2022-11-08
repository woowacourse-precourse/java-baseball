package baseball;

public class GameResult {
    private int strike;
    private int ball;
    private String gameResultMessage;

    public GameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getGameResultMessage() {
        return gameResultMessage;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.equals(BallStatus.STRIKE)) {
            strike++;
        }
        if (ballStatus.equals(BallStatus.BALL)) {
            ball++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strike == that.strike && ball == that.ball;
    }
}
