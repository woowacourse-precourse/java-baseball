package baseball;


import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
	public static final int START_INCLUSIVE = 1;
	public static final int END_INCLUSIVE = 9;

	private Ball(){}

	private static class BallHolder {
		private static final Ball INSTANCE = new Ball();
	}

	public static Ball getInstance() {
		return BallHolder.INSTANCE;
	}

	public String createRandomBall() {
		return String.valueOf(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
	}
}
