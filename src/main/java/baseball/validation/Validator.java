package baseball.validation;

import baseball.utils.Parser;

import java.util.List;

public class Validator {
	private static final int VALID_BASEBALL_NUMBER_COUNT = 3;
	private static final char ZERO = '0';

	private static final int VALID_GAME_PROCEED_NUMBER_LENGTH = 1;
	private static final char NEW_GAME = '1';
	private static final char EXIT_GAME = '2';

	private Validator() {
	}

	public static void validateGameProceedNumber(String gameProceedNumber) {
		if (!hasValidGameProceedNumberLength(gameProceedNumber)) {
			throw new IllegalArgumentException("[Error] 유효하지 않은 입력 길이입니다. " +
					"1(new game) 또는 2(exit game) 중 하나를 입력해 주세요.");
		} else if (!isValidGameProceedNumber(gameProceedNumber)) {
			throw new IllegalArgumentException("[Error] 유효하지 않은 입력입니다. " +
					"1(new game) 또는 2(exit game) 중 하나를 입력해 주세요.");
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
			throw new IllegalArgumentException("[Error] 유효하지 않은 입력 길이입니다. 서로 다른 숫자 3개를 입력해주세요");
		} else if (!hasOnlyNumeric(baseballNumberList)) {
			throw new IllegalArgumentException("[Error] 숫자만 입력해주세요");
		} else if (!hasOnlyUniqueElements(baseballNumberList)) {
			throw new IllegalArgumentException("[Error] 서로다른 숫자 3개를 입력해주세요.");
		} else if (hasZeroNumber(baseballNumberList)) {
			throw new IllegalArgumentException("[Error] 0이라는 숫자는 포함되면 안됩니다.");
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
