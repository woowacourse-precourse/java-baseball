package baseball;

import java.util.List;

public class InputException extends IllegalArgumentException {

	private static final int INPUT_LENGTH = 3;
	private static final int ZERO = 0;

	public InputException() {
	}

	public static void checkNotNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}

	public static void checkLength(String input) {
		if (input.length() != INPUT_LENGTH) {
			throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
		}
	}

	public static void checkDuplicate(List<Integer> input) {
		if (hasDuplicatedNum(input)) {
			throw new IllegalArgumentException("숫자가 중복됩니다.");
		}
	}

	private static boolean hasDuplicatedNum(List<Integer> input) {
		return input.get(0).equals(input.get(1)) || input.get(0).equals(input.get(2)) || input.get(1)
			.equals(input.get(2));
	}

	public static void checkZero(List<Integer> input) {
		if (input.contains(ZERO)) {
			throw new IllegalArgumentException("0은 입력할 수 없습니다.");
		}
	}
}
