package baseball.controller;

import java.util.Arrays;
import java.util.List;

public class Calculator {
	private static int ballCount;
	private static int strikeCount;

	public static List<Integer> getBallStrikeCount(List<Integer> randomNumberList, List<Integer> gameNumberList) {
		ballCount = 0;
		strikeCount = 0;

		compareGameNumber(randomNumberList, gameNumberList);

		List<Integer> ballStrikeCount = Arrays.asList(ballCount, strikeCount);
		return ballStrikeCount;
	}

	private static void compareGameNumber(List<Integer> randomNumberList, List<Integer> gameNumberList) {
		for (int idx = 0; idx < gameNumberList.size(); idx++) {
			addBallOrStrike(randomNumberList, gameNumberList.get(idx), idx);
		}
	}

	private static void addBallOrStrike(List<Integer> randomNumberList, int gameNumber, int gameNumberIdx) {
		if (randomNumberList.contains(gameNumber)) {
			ballCount++;
			if (randomNumberList.indexOf(gameNumber) == gameNumberIdx) {
				ballCount--;
				strikeCount++;
			}
		}
	}
}
