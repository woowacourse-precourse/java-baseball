package baseball.controller;

import java.util.List;

public class GameResult {
	private int ballCount;
	private int strikeCount;

	public GameResult(List<Integer> playerNumbers, List<Integer> computerNumbers) {
		this.ballCount = setBallCount(playerNumbers, computerNumbers);
		this.strikeCount = setStrikeCount(playerNumbers, computerNumbers);
	}

	private int setBallCount(List<Integer> playerNumbers, List<Integer> computerNumbers) {
		return (int) playerNumbers.stream()
			.filter(playerNumber -> GameResultType.isBall(playerNumber, playerNumbers, computerNumbers))
			.count();
	}

	private int setStrikeCount(List<Integer> playerNumbers, List<Integer> computerNumbers) {
		return (int) playerNumbers.stream()
			.filter(playerNumber -> GameResultType.isStrike(playerNumber, playerNumbers, computerNumbers))
			.count();
	}

	public int getBallCount() {
		return this.ballCount;
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}
}
