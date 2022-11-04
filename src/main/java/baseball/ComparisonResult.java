package baseball;

import static baseball.Constants.NUMBER_LENGTH;

import java.util.List;

public class ComparisonResult {
	static int strikeCount = 0;
	static int ballCount = 0;

	public ComparisonResult(List<Integer> userNums, List<Integer> computerNums) {
		countHint(userNums, computerNums);
	}

	private void countHint(List<Integer> userNums, List<Integer> computerNums) {
		resetCount();
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

	private static void resetCount() {
		strikeCount = 0;
		ballCount = 0;
	}
}

