package baseball;

import java.util.List;

public class Checker {
	private static final int INIT_INDEX = 0;
	private static final int END_OR_RESTART_INPUT_LENGTH = 1;
	private static final int END_INPUT = 2;
	private static final int RESTART_INPUT = 1;
	private static final int USER_NUMBER_INPUT_LENGTH = 3;
	private static final String ZERO = "0";

	public static void userInputChecker(String userInput, int length, List<Integer> userNumberList) {
		checkNumberOnlyException(userInput);
		checkLengthException(userInput, length);
		checkSameLetterException(length, userNumberList);
		checkNumberRangeException(userInput, length);
	}

	private static void checkNumberRangeException(String userInput, int length) {

		if (isEndOrRestartInput(length)) {
			if (isEndOrRestartRangeException(userInput)) {
				Exception.endOrRestartException();
			}
		}

		if (isUserNumberInput(length)) {
			if (isUserNumberInputRangeException(userInput)) {
				Exception.numberRangeException();
			}
		}
	}

	private static boolean isUserNumberInput(int length) {
		return length == USER_NUMBER_INPUT_LENGTH;
	}

	private static boolean isEndOrRestartInput(int length) {
		return length == END_OR_RESTART_INPUT_LENGTH;
	}

	private static boolean isUserNumberInputRangeException(String userNumber) {
		return userNumber.contains(ZERO);
	}

	private static boolean isEndOrRestartRangeException(String userInput) {
		return Integer.parseInt(userInput) > END_INPUT || Integer.parseInt(userInput) < RESTART_INPUT;
	}

	private static void checkSameLetterException(int length, List<Integer> userNumberList) {

		if (length > END_OR_RESTART_INPUT_LENGTH) {
			if (isUserInputSameNumber(userNumberList)) {
				Exception.sameLetterException();
			}
		}

	}

	private static void checkLengthException(String userInput, int length) {

		if (userInput.length() != length) {
			Exception.lengthException();
		}

	}

	private static void checkNumberOnlyException(String userInput) {
		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			Exception.numberOnlyException();
		}
	}

	private static boolean isUserInputSameNumber(List<Integer> userNumberList) {
		for (int targetIndex = INIT_INDEX; targetIndex < userNumberList.size(); targetIndex++) {

			if (compareNumbers(userNumberList, targetIndex)) {
				return true;
			}
		}
		return false;
	}

	private static boolean compareNumbers(List<Integer> userNumberList, int targetIndex) {
		for (int compareIndex = targetIndex + 1; compareIndex < userNumberList.size(); compareIndex++) {

			int targetNumber = userNumberList.get(targetIndex);
			int compareNumber = userNumberList.get(compareIndex);

			if (targetNumber == compareNumber) {
				return true;
			}

		}
		return false;
	}

	public static void checkReStart(Computer computer, boolean isReStart) {

		if (isReStart) {
			View.showStartGameGuideMessage();
			computer.makeRandomNumber();
		}

	}

	public static boolean isStrike(int computerNumber, Integer userNumber) {
		return computerNumber == userNumber;
	}

	public static boolean isBall(int userNumber, List<Integer> randomNumber) {
		return randomNumber.contains(userNumber);
	}

	public static boolean checkEndGame(int userInput) {

		if (userInput == END_INPUT) {
			return true;
		}

		return false;
	}
}

