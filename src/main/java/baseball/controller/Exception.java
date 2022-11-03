package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exception {
	private static final int NUMBER_LENGTH = 3;
	private static final int RESTART_NUMBER = 1;
	private static final int END_NUMBER = 2;
	private static final String ALLOW_ONLY_ONE_TO_NINE = "[ERROR] 1부터 9까지의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOW_ONLY_STANDARD_NUMBER_LENGTH = "[ERROR] 3자리의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOW_ONLY_OVERLAP_NUMBER = "[ERROR] 중복되지 않는 숫자만 입력해주시기 바랍니다.";
	private static final String ALLOW_ONLY_RESTART_OR_END_NUMBER = String.format("[ERROR] %d 혹은 %d 숫자만 입력해 주시기 바랍니다.",
		RESTART_NUMBER, END_NUMBER);

	public static void validOnlyOneToNine(String inputGameNumber) {
		String regExp = "^[1-9]+$";
		if (!inputGameNumber.matches(regExp)) {
			throw new IllegalArgumentException(ALLOW_ONLY_ONE_TO_NINE);
		}
	}

	public static void validNumberLength(String inputGameNumber) {
		if (inputGameNumber.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(ALLOW_ONLY_STANDARD_NUMBER_LENGTH);
		}
	}

	public static void validOverlapNumber(String inputGameNumber) {
		String[] inputGameNumbersArray = inputGameNumber.split("");
		Set<String> inputGameNumberSet = new HashSet<>();
		inputGameNumbersToSet(inputGameNumberSet, inputGameNumbersArray);

		if (inputGameNumberSet.size() != inputGameNumbersArray.length) {
			throw new IllegalArgumentException(ALLOW_ONLY_OVERLAP_NUMBER);
		}
	}

	private static void inputGameNumbersToSet(Set<String> inputGameNumberSet, String[] inputGameNumbersList) {
		Arrays.stream(inputGameNumbersList)
			.forEach(number -> inputGameNumberSet.add(number));
	}

	public static void validRestartOrEndNumber(String inputRestartNumber) {
		if (!inputRestartNumber.equals(RESTART_NUMBER) || !inputRestartNumber.equals(END_NUMBER)) {
			throw new IllegalArgumentException(ALLOW_ONLY_RESTART_OR_END_NUMBER);
		}
	}
}
