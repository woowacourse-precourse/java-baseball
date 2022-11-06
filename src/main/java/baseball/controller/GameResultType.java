package baseball.controller;

import java.util.List;

public class GameResultType {
	public static boolean isBall(int playerNumber, List<Integer> playerNumbers, List<Integer> randomNumbers) {
		int randomNumbersIndex = randomNumbers.indexOf(playerNumber);
		int playerNumbersIndex = playerNumbers.indexOf(playerNumber);
		if (randomNumbers.contains(playerNumber) && randomNumbersIndex != playerNumbersIndex) {
			return true;
		}
		return false;
	}

	public static boolean isStrike(int playerNumber, List<Integer> playerNumbers, List<Integer> randomNumbers) {
		int randomNumbersIndex = randomNumbers.indexOf(playerNumber);
		int playerNumbersIndex = playerNumbers.indexOf(playerNumber);
		if (randomNumbers.contains(playerNumber) && randomNumbersIndex == playerNumbersIndex) {
			return true;
		}
		return false;
	}
}
