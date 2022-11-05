package baseball.domain;

import java.util.List;

public class BaseballGameCalculator {
	private static final int[] bsoResult = new int[2];
	private static final int BALL = 0;
	private static final int STRIKE = 1;

	public int[] calculateBSO(BaseballNumber number1, BaseballNumber number2) {
		clearBSOResult();
		List<Integer> numbers1 = number1.getNumbers();
		List<Integer> numbers2 = number2.getNumbers();

		for (int i = 0; i < 3; i++) {
			if (numbers1.get(i).equals(numbers2.get(i))) {
				bsoResult[STRIKE] += 1;
				continue;
			}
			if (numbers2.contains(numbers1.get(i))) {
				bsoResult[BALL] += 1;
			}
		}

		return bsoResult.clone();
	}

	private void clearBSOResult() {
		bsoResult[BALL] = 0;
		bsoResult[STRIKE] = 0;
	}
}