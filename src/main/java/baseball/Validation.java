package baseball;

public class Validation {

	public static void validateAnswer(String input) {
		validateIsNumber(input);
		validateLength(input);
		validateNotContainZero(input);
		validateNotHaveDuplicateNumber(input);
	}

	public static void validateOneOrTwo(String input) {
		validateIsNumber(input);
		int num = Integer.parseInt(input);

		if (!(num == 1 || num == 2)) {
			throw new IllegalArgumentException("숫자 1 또는 2를 입력해 주세요.");
		}
	}

	private static void validateIsNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("문자가 입력되었습니다. 숫자를 입력해 주세요.");
		}

	}

	private static void validateNotContainZero(String input) {
		if (input.contains("0")) {
			throw new IllegalArgumentException(
					"입력값에 0이 포함되어 있습니다. 1부터 9 사이의 숫자를 입력해 주세요.");
		}
	}

	private static void validateNotHaveDuplicateNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (i != input.lastIndexOf(Character.toString(c))) {
				throw new IllegalArgumentException(
						"입력하신 값에 중복된 숫자가 있습니다. 서로 다른 3가지 숫자를 입력해 주세요.");
			}
		}
	}

	private static void validateLength(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException(
					"입력하신 값이 3자리가 아닙니다. 3자리 수를 입력해 주세요.");
		}
	}
}
