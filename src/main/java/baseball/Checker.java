package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Checker {
	private static final int ZERO = 0;
	private static final int END_OR_RESTART_INPUT_LENGTH = 1;
	private static final int END_INPUT = 2;
	private static final int RESTART_INPUT = 1;

	public void userInputChecker(String userNumber, int length, Player player) {
		checkNumberOnlyError(userNumber);
		checkLengthError(userNumber, length);
		checkEndOrRestartError(userNumber, length);
		checkSameLetterError(length, player);
		checkNumberRangeError(userNumber);
	}

	private void checkNumberRangeError(String userNumber) {
		if (userNumber.contains(Integer.toString(ZERO))) {
			Exception.numberRangeError();
		}
	}

	private void checkSameLetterError(int length, Player player) {
		if (length > END_OR_RESTART_INPUT_LENGTH) {
			if (isUserInputSameNumber(player)) {
				Exception.sameLetterError();
			}
		}
	}

	private void checkEndOrRestartError(String userNumber, int length) {
		if (length == END_OR_RESTART_INPUT_LENGTH) {
			if (Integer.parseInt(userNumber) > END_INPUT || Integer.parseInt(userNumber) < RESTART_INPUT) {
				Exception.endOrRestartError();
			}
		}
	}

	private void checkLengthError(String userNumber, int length) {
		if (userNumber.length() != length) {
			Exception.lengthError();
		}
	}

	private void checkNumberOnlyError(String userNumber) {
		try {
			Integer.parseInt(userNumber);
		} catch (NumberFormatException e) {
			Exception.numberOnlyError();
		}
	}

	public boolean isUserInputSameNumber(Player player) {

		for (int targetIndex = ZERO; targetIndex < player.getUserNumberList().size(); targetIndex++) {

			for (int compareIndex = targetIndex + 1; compareIndex < player.getUserNumberList().size(); compareIndex++) {

				int targetNumber = player.getUserNumberList().get(targetIndex);
				int compareNumber = player.getUserNumberList().get(compareIndex);

				if (targetNumber == compareNumber) {
					return true;
				}

			}
		}
		return false;
	}
}

