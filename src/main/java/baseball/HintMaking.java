package baseball;

public class HintMaking {

	public static final String NOTHING = "낫싱";
	public static final String BALL = "볼";
	public static final String STRIKE = "스트라이크";
	public static final int START_IDX = 0;
	public static final int END_IDX = 3;
	public static final int ZERO = 0;

	public static int findBall(int idx, char singleDigit, char[] userInputAnsToCharArray) {
		for (int digit = START_IDX; digit < END_IDX; digit++) {
			if (digit == idx) {
				continue;
			}
			if (singleDigit == userInputAnsToCharArray[digit]) {
				return 1;
			}
		}
		return 0;
	}

	public static void countBallAndStrike(int ans, int userInputAns) {
		int strike = 0;
		int ball = 0;

		char[] ansToCharArray = String.valueOf(ans).toCharArray();
		char[] userInputAnsToCharArray = String.valueOf(userInputAns).toCharArray();

		for (int digit = START_IDX; digit < END_IDX; digit++) {
			if (ansToCharArray[digit] == userInputAnsToCharArray[digit]) {
				strike++;
			} else {
				ball += findBall(digit, ansToCharArray[digit], userInputAnsToCharArray);
			}
		}

		makeHint(ball, strike);
	}

	public static void makeHint(int ball, int strike) {
		StringBuilder sb = new StringBuilder();
		if (strike == ZERO && ball == ZERO) {
			sb.append(NOTHING);
		}
		if (ball > ZERO) {
			sb.append(ball).append(BALL).append(" ");
		}
		if (strike > ZERO) {
			sb.append(strike).append(STRIKE);
		}
		PrintHandler.printHint(sb.toString());
	}
}
