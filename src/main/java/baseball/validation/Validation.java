package baseball.validation;

import java.util.List;

import baseball.exception.Exception;
import baseball.input.GameCommand;
import baseball.input.InputLength;
import baseball.input.NumberRange;

public class Validation {

	public static void validatePlayerInput(String playerInput, int length, List<Integer> playerNumberList) {
		validateNumberOnly(playerInput);
		validateLength(playerInput, length);
		validateSameLetter(playerNumberList);
		validateNumberRange(playerNumberList);
	}

	public static void validateNumberOnly(String playerInput) {
		try {
			Integer.parseInt(playerInput);
		} catch (NumberFormatException e) {
			throw Exception.NUMBER_ONLY_EXCEPTION.getException();
		}
	}

	public static void validateLength(String playerInput, int length) {
		if (isLengthException(playerInput, length)) {
			throw Exception.LENGTH_EXCEPTION.getException();
		}
	}

	private static boolean isLengthException(String playerInput, int length) {
		return playerInput.length() != length;
	}

	public static void validateNumberRange(List<Integer> playerNumberList) {
		for (Integer number : playerNumberList) {
			if (isNumberRangeException(number)) {
				throw Exception.NUMBER_RANGE_EXCEPTION.getException();
			}
		}
	}

	private static boolean isNumberRangeException(int playerInput) {
		return playerInput > NumberRange.MAX.getNumber()
			|| playerInput < NumberRange.MIN.getNumber();
	}

	public static void validateSameLetter(List<Integer> playerNumberList) {
		if (isPlayerInputSameNumber(playerNumberList)) {
			throw Exception.SAME_LETTER_EXCEPTION.getException();
		}
	}

	private static boolean isPlayerInputSameNumber(List<Integer> playerNumberList) {
		boolean isSameNumberExist = playerNumberList.stream()
			.distinct()
			.count() != playerNumberList.size();

		return isSameNumberExist;
	}

	public static boolean isSameNumberExistInRandomNumber(int number, List<Integer> randomNumber) {
		if (randomNumber.contains(number)) {
			return true;
		}
		return false;
	}

	public static boolean isStrike(int computerNumber, Integer playerNumber) {
		return computerNumber == playerNumber;
	}

	public static boolean isBall(int playerNumber, List<Integer> randomNumber) {
		return randomNumber.contains(playerNumber);
	}

	public static void validateGameCommand(String playerInput) {
		validateNumberOnly(playerInput);
		validateLength(playerInput, InputLength.GAME_COMMAND_INPUT_LENGTH.getLength());
		validateGameCommandRange(Integer.parseInt(playerInput));
	}

	public static void validateGameCommandRange(int playerInput) {
		if (isGameCommandRangeException(playerInput)) {
			throw Exception.GAME_COMMAND_EXCEPTION.getException();
		}
	}

	private static boolean isGameCommandRangeException(int playerInput) {
		return playerInput != GameCommand.RE_START.getCommand() && playerInput != GameCommand.END.getCommand();
	}
}

