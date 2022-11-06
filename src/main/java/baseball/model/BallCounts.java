package baseball.model;

public class BallCounts {
    private static int strike;
    private static int ball;

    public static void setBallCounts(int strike, int ball) {
	BallCounts.strike = strike;
	BallCounts.ball = ball;
    }

    public static int getStrike() {
	return strike;
    }

    public static int getBall() {
	return ball;
    }
}