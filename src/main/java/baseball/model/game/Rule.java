package baseball.model.game;

import java.util.Objects;

public class Rule {

	public static int STRIKE;
	public static int BALL;
	public static boolean USER_WIN;
	public static int USER_INTENTION;


	public boolean isStrike(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && Objects.equals(computerIdx, userIdx);
	}

	public boolean isBall(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && !Objects.equals(computerIdx, userIdx);
	}

	public boolean isNothing() {
		return Objects.equals(STRIKE, 0) && Objects.equals(BALL, 0);
	}

	public boolean userWin() {
		return STRIKE == 3;
	}

}
