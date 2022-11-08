package baseball.util;

public class InputValidUtil {

	public boolean checkInputValid(String userInputNumber) {
		int[] inputNumInts = userInputNumber.chars()
			.map(num -> Integer.parseInt(num + "") - 48)
			.toArray();
		return has3Length(inputNumInts) && isNumber(inputNumInts) && hasDifferentNumber(inputNumInts);
	}

	private boolean hasDifferentNumber(int[] inputNumInts) {
		if (inputNumInts[0] == inputNumInts[1] || inputNumInts[0] == inputNumInts[2]
			|| inputNumInts[1] == inputNumInts[2]) {
			throw new IllegalArgumentException(ErrorConst.DUPLICATED_ERROR);
		}
		return true;
	}

	private boolean isNumber(int[] inputNumInts) {
		for (int i = 0; i < 3; i++) {
			if (1 > inputNumInts[i] || 9 < inputNumInts[i]) {
				throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
			}
		}
		return true;
	}

	private boolean has3Length(int[] inputNumInts) {
		if (inputNumInts.length != ViewConst.INPUT_NUM_LENGTH) {
			throw new IllegalArgumentException(ErrorConst.NUMBER_LENGTH_ERROR);
		}
		return true;
	}
}
