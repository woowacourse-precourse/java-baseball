package baseball;

import static util.GameUtil.STLIKE_FULL;

import java.util.ArrayList;

public class BaseballUmpire {

	private int ball;
	private int strike;

	public BaseballUmpire() {
		this.strike = 0;
		this.ball = 0;
	}

	private void refereeBall(boolean isBall, boolean isStrike) {
		if (isStrike && isBall) {
			this.strike++;
		} else if (isBall) {
			this.ball++;
		}
	}

	private void compareBalls(int userBall, ArrayList<Integer> computerBalls, int ballCount) {
		for (int computerBallCount = 0; computerBallCount < computerBalls.size();
			computerBallCount++) {
			int computerBall = computerBalls.get(computerBallCount);
			boolean isStrike = (ballCount == computerBallCount);
			boolean isBall = (userBall == computerBall);
			refereeBall(isBall, isStrike);
		}
	}

	public boolean refereeBalls(String userBalls, ArrayList<Integer> computerBalls) {
		for (int ballCount = 0; ballCount < userBalls.length(); ballCount++) {
			int userBall = userBalls.charAt(ballCount) - '0';
			compareBalls(userBall, computerBalls, ballCount);
		}

		Console.printHint(this.strike, this.ball);

		if (this.strike == STLIKE_FULL) {
			return false;
		}
		return true;
	}

}
