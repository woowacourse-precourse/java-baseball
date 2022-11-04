package baseball.controller;

import baseball.Player;
import java.util.List;

public class Calculator {
	private static List<Integer> randomNumbers;

	public static void checkPlayerNumbers(Player player, List<Integer> randomNumbers) {
		Calculator.randomNumbers = randomNumbers;
		List<Integer> playerNumbers = player.getNumbers();
		playerNumbers.stream().
			forEach(playerNumber -> addBallOrStrike(player, playerNumbers, playerNumber));
	}

	private static void addBallOrStrike(Player player, List<Integer> playerNumbers, int playerNumber) {
		int playerNumberIdx = playerNumbers.indexOf(playerNumber);
		if (randomNumbers.contains(playerNumber)) {
			int randomNumberIdx = randomNumbers.indexOf(playerNumber);
			addBall(player, playerNumberIdx, randomNumberIdx);
			addStrike(player, playerNumberIdx, randomNumberIdx);
		}
	}

	private static void addBall(Player player, int playerNumberIdx, int randomNumberIdx) {
		if (randomNumberIdx != playerNumberIdx) {
			player.addBall();
		}
	}

	private static void addStrike(Player player, int playerNumberIdx, int randomNumberIdx) {
		if (randomNumberIdx == playerNumberIdx) {
			player.addStrike();
		}
	}
}
