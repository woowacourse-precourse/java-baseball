package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Checker {
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final String ERROR = "[ERROR] ";
	public static final String NUMBER_ONLY_ERROR_MESSAGE = ERROR + "숫자만 입력해주세요.";
	public static final String LENGTH_ERROR_MESSAGE = ERROR + "올바른 길이의 숫자를 입력해주세요.";
	public static final String NUMBER_RANGE_ERROR_MESSAGE = ERROR + "1~9 사이의 숫자만 입력 가능 합니다.";
	public static final String SAME_LETTER_ERROR_MESSAGE = ERROR + "중복되는 숫자는 입력할 수 없습니다.";
	public static final String END_OR_RESTART_INPUT_ERROR_MESSAGE = ERROR + "1혹은 2를 입력해주세요";

	public void userInputChecker(String userNumber, int length, Player player) {
		try {
			Integer.parseInt(userNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_ONLY_ERROR_MESSAGE);
		}

		if (userNumber.length() != length) {
			throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
		}

		if (length == ONE) {
			if (Integer.parseInt(userNumber) > 2 || Integer.parseInt(userNumber) < 1) {
				throw new IllegalArgumentException(END_OR_RESTART_INPUT_ERROR_MESSAGE);
			}
		}

		if (length > ONE) {
			if (isUserInputSameNumber(player)) {
				throw new IllegalArgumentException(SAME_LETTER_ERROR_MESSAGE);
			}
			if (userNumber.contains("0")) {
				throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
			}
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

