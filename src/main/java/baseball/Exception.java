package baseball;

import static util.GameUtil.BALL_MAX_SIZE;
import static util.GameUtil.INPUT_DUPLICATION_ERROR;
import static util.GameUtil.INPUT_RANGE_ERROR;
import static util.GameUtil.INPUT_TYPE_ERROR;

import java.util.HashSet;
import java.util.Set;

public class Exception {

	public static void check(String input) throws IllegalArgumentException {
		Set<Character> removeDuplicate = new HashSet<>();

		maxCheck(input);
		for (char individualValue : input.toCharArray()) {
			typeCheck(individualValue);
			removeDuplicate.add(individualValue);
		}
		duplicationCheck(removeDuplicate);
	}

	private static void maxCheck(String input) {
		if (input.length() != BALL_MAX_SIZE) {
			throw new IllegalArgumentException(INPUT_RANGE_ERROR);
		}
	}

	private static void typeCheck(char individualValue) {
		if (!Character.isDigit(individualValue)) {
			throw new IllegalArgumentException(INPUT_TYPE_ERROR);
		}
	}

	private static void duplicationCheck(Set<Character> removeDuplicate) {
		if (removeDuplicate.size() != BALL_MAX_SIZE) {
			throw new IllegalArgumentException(INPUT_DUPLICATION_ERROR);
		}
	}
}
