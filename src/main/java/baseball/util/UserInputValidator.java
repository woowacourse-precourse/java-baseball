package baseball.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class UserInputValidator {

	public static void validatePlayNumbers(String userInput) throws IllegalArgumentException {
		if (isThreeLengthNumber(userInput)
				&& isUniqueNumbers(userInput)) {
			return;
		}

		throw new IllegalArgumentException();
	}

	public static void validateRestartCode(String userInput) {
		if (isSingleRestartCode(userInput)) {
			return;
		}

		throw new IllegalArgumentException();
	}

	private static boolean isThreeLengthNumber(String userInput) {
		String pattern = "^[1-9]{3}$"; // 1 ~ 9 사이의 3자리 숫자

		return Pattern.matches(pattern, userInput);
	}

	private static boolean isUniqueNumbers(String userInput) {
		int beforeSize = userInput.length();
		long afterDistinctSize = Arrays.stream(userInput.split(""))
			.distinct()
			.count(); // 중복이 존재하는 경우 size 가 줄어듦

		return afterDistinctSize == beforeSize;
	}

	private static boolean isSingleRestartCode(String userInput) {
		String pattern = "^[1-2]$"; // 1, 2 둘 중 하나

		return Pattern.matches(pattern, userInput);
	}
}
