package baseball.model;

public class BallCounts {
    private static int strike;
    private static int ball;
    private static boolean isNothing = false;

    public static int getStrike() {
	return strike;
    }

    public static int getBall() {
	return ball;
    }

    public static boolean getIsNothing() {
	return isNothing;
    }


    public static void setBallCounts(Numbers answerNumbers, Numbers inputNumbers) {
	strike = answerNumbers.compareStrikeByInput(inputNumbers);
	ball = answerNumbers.compareBallByInput(inputNumbers);
	isNothing = ((strike + ball) == 0);
    }
}