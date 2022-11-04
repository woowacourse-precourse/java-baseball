package baseball;

import java.util.List;

public class ComparisonResult {
	private static final int NUMBER_LENGTH = 3;
	static int strikeCount = 0;
	static int ballCount = 0;

	public ComparisonResult(List<Integer> userNums, List<Integer> computerNums) {
		countHint(userNums, computerNums);
	}

	private void countHint(List<Integer> userNums, List<Integer> computerNums) {
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (userNums.get(i).equals(computerNums.get(i))) {
				strikeCount++;
				continue;
			}
			if (computerNums.contains(userNums.get(i))) {
				ballCount++;
			}
		}
	}
}

