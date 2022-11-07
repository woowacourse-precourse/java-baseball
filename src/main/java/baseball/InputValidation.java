package baseball;

public class InputValidation {

	public static void validateOption(final String option) {
		validateInput(option);
		int gameOption = Integer.parseInt(option);
		if (!GameOption.matchOption(gameOption)) {
			throw new IllegalArgumentException("잘못된 옵션을 입력하셨습니다.");
		}
	}

	public static void validateInput(final String input) {
		if (!isAllDigits(input)) {
			throw new IllegalArgumentException("1에서 9까지의 숫자만 입력가능합니다.");
		}
	}

	private static boolean isAllDigits(final String input) {
		return input.chars()
			.allMatch(Character::isDigit);
	}
}
