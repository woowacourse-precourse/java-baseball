package baseball.domain;

import java.util.List;
import java.util.stream.Stream;

public class GameResult {
	public final int ballCount;
	public final int strikeCount;

	public GameResult(List<Integer> computerNums, List<Integer> userNums) {
		this.ballCount = countBall(computerNums, userNums);
		this.strikeCount = countStrike(computerNums, userNums);
	}

	private int countBall(List<Integer> computerNums, List<Integer> userNums) {
		return (int)Stream.iterate(0, i -> i + 1).limit(computerNums.size())
			.filter(num -> !computerNums.get(num).equals(userNums.get(num)) && computerNums.contains(userNums.get(num)))
			.count();
	}

	private int countStrike(List<Integer> computerNums, List<Integer> userNums) {
		return (int)Stream.iterate(0, i -> i + 1).limit(computerNums.size())
			.filter(num -> computerNums.get(num).equals(userNums.get(num))).count();
	}
}
