package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exception {
	private static final int NUMBER_LENGTH = 3;
	private static final String ALLOWED_ONLY_ONE_TO_NINE = "[Error] 1부터 9까지의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOWED_ONLY_STANDARD_NUMBER_LENGTH = "[Error] 3자리의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOWED_NOT_OVERLAP_NUMBER = "[Error] 중복되지 않는 숫자만 입력해주시기 바랍니다.";

	public static void validOnlyOneToNine(String inputGameNumber) {
		String regExp = "^[1-9]+$";
		if (!inputGameNumber.matches(regExp)) {
			throw new IllegalArgumentException(ALLOWED_ONLY_ONE_TO_NINE);
		}
	}

	public static void validNumberLength(String inputGameNumber) {
		if (inputGameNumber.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(ALLOWED_ONLY_STANDARD_NUMBER_LENGTH);
		}
	}

	public static void validOverlapNumber(String inputGameNumber) {
		String[] inputGameNumbersArray = inputGameNumber.split("");
		Set<String> inputGameNumberSet = new HashSet<>();
		inputGameNumbersToSet(inputGameNumberSet, inputGameNumbersArray);

		if (inputGameNumberSet.size() != inputGameNumbersArray.length) {
			throw new IllegalArgumentException(ALLOWED_NOT_OVERLAP_NUMBER);
		}
	}

	private static void inputGameNumbersToSet(Set<String> inputGameNumberSet, String[] inputGameNumbersList) {
		Arrays.stream(inputGameNumbersList)
			.forEach(number -> inputGameNumberSet.add(number));
	}
}
