package baseball.validator;

import static baseball.constant.Constants.*;

public class GameInputValidator {

	public static void validateRestartInput(String input) {
		int inputParseInt;
		try {
			inputParseInt = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		if (!(inputParseInt == RESTART_GAME || inputParseInt == STOP_GAME)) {
			throw new IllegalArgumentException();
		}
	}
}
