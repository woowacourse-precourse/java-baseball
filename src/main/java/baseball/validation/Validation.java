package baseball.validation;

import java.util.List;

import baseball.domain.Computer;
import baseball.exception.Exception;

public class Validation {
	private static final int GAME_COMMAND_INPUT_LENGTH = 1;
	private static final int END_INPUT_LENGTH = 2;
	private static final int RESTART_INPUT_LENGTH = 1;
	private static final int NUMBER_INPUT_LENGTH = 3;
	private static final String ZERO = "0";

	public static void userInputChecker(String userInput, int length, List<Integer> userNumberList) {
		checkNumberOnlyException(userInput);
		checkLengthException(userInput, length);
		checkSameLetterException(length, userNumberList);
		checkNumberRangeException(userInput, length);
	}

	private static void checkNumberOnlyException(String userInput) {
		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw Exception.NUMBER_ONLY_EXCEPTION.getException();
		}
	}

	private static void checkLengthException(String userInput, int length) {

		if (userInput.length() != length) {
			throw Exception.LENGTH_EXCEPTION.getException();
		}

	}

	private static void checkNumberRangeException(String userInput, int length) {

		if (isEndOrRestartInput(length)) {
			if (isEndOrRestartRangeException(userInput)) {
				throw Exception.GAME_COMMAND_EXCEPTION.getException();
			}
		}

		if (isUserNumberInput(length)) {
			if (isUserNumberInputRangeException(userInput)) {
				throw Exception.NUMBER_RANGE_EXCEPTION.getException();
			}
		}
	}

	private static boolean isEndOrRestartInput(int length) {
		return length == GAME_COMMAND_INPUT_LENGTH;
	}

	private static boolean isEndOrRestartRangeException(String userInput) {
		return Integer.parseInt(userInput) > END_INPUT_LENGTH || Integer.parseInt(userInput) < RESTART_INPUT_LENGTH;
	}

	private static boolean isUserNumberInput(int length) {
		return length == NUMBER_INPUT_LENGTH;
	}

	private static boolean isUserNumberInputRangeException(String userNumber) {
		return userNumber.contains(ZERO);
	}

	private static void checkSameLetterException(int length, List<Integer> userNumberList) {

		if (length > GAME_COMMAND_INPUT_LENGTH) {
			if (isUserInputSameNumber(userNumberList)) {
				throw Exception.SAME_LETTER_EXCEPTION.getException();
			}
		}

	}

	private static boolean isUserInputSameNumber(List<Integer> userNumberList) {
		boolean isSameNumberExist = userNumberList.stream()
			.distinct()
			.count() != userNumberList.size();

		return isSameNumberExist;
	}

	public static boolean isSameNumberExistInRandomNumber(int number, List<Integer> randomNumber) {

		if (randomNumber.contains(number)) {
			return true;
		}
		return false;
	}

	public static void checkReStart(Computer computer, boolean isReStart) {

		if (isReStart) {
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

		if (userInput == END_INPUT_LENGTH) {
			return true;
		}

		return false;
	}
}

