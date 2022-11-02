package baseball.validation;

import baseball.utils.Parser;

import java.util.List;

public class Validator {
	private static final int VALID_BASEBALL_NUMBER_COUNT = 3;
	private static final char ZERO = '0';

	private Validator() {}

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
