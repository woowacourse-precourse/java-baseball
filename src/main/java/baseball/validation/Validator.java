package baseball.validation;

import baseball.utils.Parser;

import java.util.List;

import static baseball.constants.Constant.*;
import static baseball.constants.Message.*;

public class Validator {

	private Validator() {
	}

	public static void validateGameProceedNumber(String gameProceedNumber) {
		if (!hasValidGameProceedNumberLength(gameProceedNumber)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_PROGRESS_INPUT_LENGTH);
		}
		if (!isValidGameProceedNumber(gameProceedNumber)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_PROGRESS_INPUT);
		}
	}

	private static boolean hasValidGameProceedNumberLength(String gameProceedNumber) {
		return gameProceedNumber.length() == VALID_GAME_PROCEED_NUMBER_LENGTH;
	}

	private static boolean isValidGameProceedNumber(String gameProceedNumber) {
		return gameProceedNumber.charAt(0) == NEW_GAME || gameProceedNumber.charAt(0) == EXIT_GAME;
	}

	public static void validateBaseballNumber(String baseballNumber) {
		List<Character> baseballNumberList = Parser.parseStringToCharList(baseballNumber);

		if (!hasValidSizeOfBaseballNumberList(baseballNumberList)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_BASEBALL_INPUT_LENGTH);
		}
		if (!hasOnlyNumeric(baseballNumberList)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_BASEBALL_INPUT_ASCII);
		}
		if (!hasOnlyUniqueElements(baseballNumberList)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_BASEBALL_INPUT_DISTINCT);
		}
		if (hasZeroNumber(baseballNumberList)) {
			throw new IllegalArgumentException(ERROR_INVALID_USER_BASEBALL_INPUT_ZERO_VALUE);
		}
	}

	private static boolean hasValidSizeOfBaseballNumberList(List<Character> baseballNumbers) {
		return baseballNumbers.size() == VALID_BASEBALL_NUMBER_COUNT;
	}

	private static boolean hasOnlyUniqueElements(List<Character> baseballNumbers) {
		return baseballNumbers.stream()
				.distinct()
				.count() == VALID_BASEBALL_NUMBER_COUNT;
	}

	private static boolean hasOnlyNumeric(List<Character> baseballNumbers) {
		return baseballNumbers.stream()
				.allMatch(Character::isDigit);
	}

	private static boolean hasZeroNumber(List<Character> baseballNumberList) {
		return baseballNumberList.stream()
				.anyMatch(c -> c == ZERO);
	}
}
