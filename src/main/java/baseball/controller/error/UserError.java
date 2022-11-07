package baseball.controller.error;

import java.util.Objects;

import static baseball.controller.Setup.*;

public class UserError {
	public static void handleGuessingError(String userInput) {
		if (!followDuplicationRule(userInput) || !followDigitRule(userInput, Integer.parseInt(NUMBER_LENGTH.getValue())) || !followNumberOnlyRule(userInput)) {
			throw new IllegalArgumentException(ERROR_MESSAGE.getValue());
		}
	}

	public static void handleIntentionError(String userInput) {
		if (!followNumberOnlyRule(userInput) || !followSelectionOption(userInput)) {
			throw new IllegalArgumentException(ERROR_MESSAGE.getValue());
		}
	}

	public static boolean followDuplicationRule(CharSequence userInput) {
		return Boolean.parseBoolean(DUPLICATION_ALLOWABLE.getValue()) == hasDuplication(userInput);
	}

	public static boolean followDigitRule(String checkString, int checkLength) {
		return Objects.equals(checkLength, checkString.length());
	}

	public static boolean followNumberOnlyRule(String checkString) {
		return checkString.matches(NUMBER_ONLY_RULE.getValue());
	}

	public static boolean followSelectionOption(String checkString) {
		return checkString.matches(SELECTION_SCOPE.getValue());
	}

	public static boolean hasDuplication(CharSequence checkString) {
		return checkString.length() != checkString.chars()
				.distinct()
				.count();
	}
}
