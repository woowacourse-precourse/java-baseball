package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exception {
	private static final int NUMBER_LENGTH = 3;
	private static final String ALLOW_ONLY_ONE_TO_NINE = "[ERROR] 1부터 9까지의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOW_ONLY_STANDARD_NUMBER_LENGTH = "[ERROR] 3자리의 숫자만 입력해 주시기 바랍니다.";
	private static final String ALLOW_ONLY_OVERLAP_NUMBER = "[ERROR] 중복되지 않는 숫자만 입력해주시기 바랍니다.";

	public static void validatePlayerNumber(String inputPlayerNumber) {
		try {
			validateOnlyOneToNine(inputPlayerNumber);
			validateNumberLength(inputPlayerNumber);
			validateOverlapNumber(inputPlayerNumber);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			throw new IllegalArgumentException();
		}
	}

	public static void validateOnlyOneToNine(String inputPlayerNumber) {
		String regExp = "^[1-9]+$";
		if (!inputPlayerNumber.matches(regExp)) {
			throw new IllegalArgumentException(ALLOW_ONLY_ONE_TO_NINE);
		}
	}

	public static void validateNumberLength(String inputPlayerNumber) {
		if (inputPlayerNumber.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(ALLOW_ONLY_STANDARD_NUMBER_LENGTH);
		}
	}

	public static void validateOverlapNumber(String inputPlayerNumber) {
		String[] inputPlayerNumbers = inputPlayerNumber.split("");
		Set<String> inputPlayerNumberSet = new HashSet<>();
		inputPlayerNumbersToSet(inputPlayerNumberSet, inputPlayerNumbers);

		if (inputPlayerNumberSet.size() != inputPlayerNumbers.length) {
			throw new IllegalArgumentException(ALLOW_ONLY_OVERLAP_NUMBER);
		}
	}

	private static void inputPlayerNumbersToSet(Set<String> inputPlayerNumberSet, String[] inputPlayerNumber) {
		Arrays.stream(inputPlayerNumber)
			.forEach(number -> inputPlayerNumberSet.add(number));
	}

	public static void validateRestartNumber(String inputRestartNumber, int restartNumber, int exitNumber) {
		try {
			Exception.validateRestartOrExitNumber(inputRestartNumber, restartNumber, exitNumber);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			throw new IllegalArgumentException();
		}
	}

	public static void validateRestartOrExitNumber(String inputRestartNumber, int restartNumber, int exitNumber) {
		String stringRestartNumber = Integer.toString(restartNumber);
		String stringExitNumber = Integer.toString(exitNumber);
		if (!inputRestartNumber.equals(stringRestartNumber) && !inputRestartNumber.equals(stringExitNumber)) {
			String allowOnlyRestartOrExitNumber = String.format("[ERROR] %d 혹은 %d 숫자만 입력해 주시기 바랍니다.",
				restartNumber, exitNumber);
			throw new IllegalArgumentException(allowOnlyRestartOrExitNumber);
		}
	}
}
