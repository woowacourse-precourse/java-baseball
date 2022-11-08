package baseball.model.strikeandball;

public class StrikeAndBall {
    int strike;
    int ball;

    public StrikeAndBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        if (strike == 3 && ball == 0) return true;
        else return false;
    }
}
