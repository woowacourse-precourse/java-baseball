package baseball.domain;

import java.util.List;

public class Referee {

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
