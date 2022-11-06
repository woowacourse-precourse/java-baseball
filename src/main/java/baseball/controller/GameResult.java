package baseball.controller;

import java.util.List;

public class GameResult {
	private int ballCount;
	private int strikeCount;

	public GameResult(List<Integer> playerNumbers, List<Integer> randomNumbers) {
		this.ballCount = setBallCount(playerNumbers, randomNumbers);
		this.strikeCount = setStrikeCount(playerNumbers, randomNumbers);
	}

	private int setBallCount(List<Integer> playerNumbers, List<Integer> randomNumbers) {
		return (int) playerNumbers.stream()
			.filter(playerNumber -> GameResultType.isBall(playerNumber, playerNumbers, randomNumbers))
			.count();
	}

	private int setStrikeCount(List<Integer> playerNumbers, List<Integer> randomNumbers) {
		return (int) playerNumbers.stream()
			.filter(playerNumber -> GameResultType.isStrike(playerNumber, playerNumbers, randomNumbers))
			.count();
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}
}
