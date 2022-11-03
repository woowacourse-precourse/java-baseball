package baseball.util;

public class InputValidUtil {

	//Todo: 입력값 타당성 체크
	public boolean checkInputValid(String userInput) {

		int[] inputNumInts = userInput.chars()
			.map(num -> Integer.parseInt(num + "") - 48)
			.toArray();

		return has3Length(inputNumInts) && isNumber(inputNumInts) && hasDifferentNumber(inputNumInts);
	}

	/**
	 *
	 * 서로 다른 3개의 수 여야함
	 */
	private boolean hasDifferentNumber(int[] inputNumInts) {
		if (inputNumInts[0] == inputNumInts[1] || inputNumInts[0] == inputNumInts[2]
			|| inputNumInts[1] == inputNumInts[2]) {
			throw new IllegalArgumentException(ErrorConst.DUPLICATED_ERROR);
		}
		return true;
	}

	/**
	 * 각자리가 숫자여야함
	 */
	private boolean isNumber(int[] inputNumInts) {
		for (int i = 0; i < 3; i++) {
			if (1 > inputNumInts[i] || 9 < inputNumInts[i]) {
				throw new IllegalArgumentException(ErrorConst.NUMBER_ERROR);
			}
		}
		return true;
	}

	/**
	 * 길이가 3이어야함
	 */
	private boolean has3Length(int[] inputNumInts) {
		if (inputNumInts.length != ViewConst.INPUT_NUM_LENGTH) {
			throw new IllegalArgumentException(ErrorConst.NUMBER_LENGTH_ERROR);
		}
		return true;
	}
}
