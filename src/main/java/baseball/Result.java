package baseball;

public class Result {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        strike += 1;
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        ball += 1;
    }

    public void reset() {
        strike = 0;
        ball = 0;
    }

    public void print() {
        if (strike == 0 && ball == 0) {
            System.out.println(Constants.NOTHING_MESSAGE);
        } else if (ball == 0) {
            System.out.println(strike + Constants.STRIKE_MESSAGE);
        } else if (strike == 0) {
            System.out.println(ball + Constants.BALL_MESSAGE);
        } else {
            System.out.print(ball + Constants.BALL_MESSAGE + " ");
            System.out.println(strike + Constants.STRIKE_MESSAGE);
        }
    }
}
