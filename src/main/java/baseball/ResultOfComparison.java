package baseball;

import java.util.List;

public class ResultOfComparison {
	static int strikeCount = 0;
	static int ballCount = 0;

	public ResultOfComparison(List<Integer> userNums, List<Integer> computerNums) {
		countHint(userNums, computerNums);
	}

	private void countHint(List<Integer> userNums, List<Integer> computerNums) {
		resetCount();
		strikeCount = getStrikeCount(userNums, computerNums);
		ballCount = getBallCount(userNums, computerNums);
	}

	private static void resetCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	private static int getBallCount(List<Integer> userNums, List<Integer> computerNums) {
		return (int)userNums.stream()
			.filter(number -> computerNums.indexOf(number) != userNums.indexOf(number))
			.filter(computerNums::contains)
			.count();
	}

	private static int getStrikeCount(List<Integer> userNums, List<Integer> computerNums) {
		return (int)userNums.stream()
			.filter(number -> computerNums.indexOf(number) == userNums.indexOf(number))
			.count();
	}
}
