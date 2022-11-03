package baseball.domain;

import java.util.List;

public class Referee {

	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	public static void printResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		String result = getResult(computerNumbers, playerNumbers);
		System.out.println(result);
	}

	private static String getResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int sameCount = getSameCount(computerNumbers, playerNumbers);
		int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
		int ballCount = getBallCount(computerNumbers, playerNumbers);

		if (sameCount == 0) {
			return NOTHING;
		}

		if (strikeCount == 0) {
			return ballCount + BALL;
		}

		if (ballCount == 0) {
			return strikeCount + STRIKE;
		}

		return ballCount + BALL + " " + strikeCount + STRIKE;
	}

	private static int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int sameCount = getSameCount(computerNumbers, playerNumbers);
		int strikeCount = getStrikeCount(computerNumbers, playerNumbers);

		return sameCount - strikeCount;
	}

	public static int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int strikeCount = 0;

		for (int i = 0; i < playerNumbers.size(); i++) {
			if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	private static int getSameCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		int sameCount = 0;

		for (Integer playerNumber : playerNumbers) {
			if (computerNumbers.contains(playerNumber)) {
				sameCount++;
			}
		}

		return sameCount;
	}

}
