package baseball.model;

public class BallCounts {
    private int strike;
    private int ball;
    private boolean isNothing = false;

    public int getStrike() {
	return strike;
    }

    public int getBall() {
	return ball;
    }

    public boolean getIsNothing() {
	return isNothing;
    }


    public void setBallCounts(Numbers answerNumbers, Numbers inputNumbers) {
	strike = answerNumbers.compareStrikeByInput(inputNumbers);
	ball = answerNumbers.compareBallByInput(inputNumbers);
	isNothing = ((strike + ball) == 0);
    }
}