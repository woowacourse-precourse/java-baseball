package baseball.util;

import java.util.Arrays;
import java.util.stream.Collectors;

import baseball.constant.GameConstants;

public class Validator {
	public static void validateNumberInput(String numberInput) throws IllegalArgumentException {
		if (existInvalidDigits(numberInput) || existDuplicateNumber(numberInput) || haveInvalidLength(numberInput)) {
			throw new IllegalArgumentException("올바른 입력이 아닙니다. 게임을 종료합니다.");
		}
	}

	public static void validateRestartOrNotInput(String input) throws IllegalArgumentException {
		if (!input.equals(GameConstants.RESTART_GAME) && !input.equals(GameConstants.END_GAME)) {
			throw new IllegalArgumentException("올바른 입력이 아닙니다. 게임을 종료합니다.");
		}
	}

	private static boolean existDuplicateNumber(String numberInput) {
		return Arrays.stream(numberInput.split("")).distinct().count() != numberInput.length();
	}

	private static boolean existInvalidDigits(String numberInput) {
		return Arrays.stream(numberInput.split(""))
			.anyMatch(letter -> !GameConstants.VALID_DIGITS.stream()
				.map(Object::toString)
				.collect(Collectors.toList())
				.contains(letter));
	}

	private static boolean haveInvalidLength(String numberInput) {
		return numberInput.length() != GameConstants.LENGTH_OF_NUMBER;
	}
}
