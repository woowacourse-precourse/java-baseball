package baseball.views;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static baseball.constants.Message.*;

public class Reader {

	public static String getUserBaseBallNumber() {
		String userBaseballNumber = getUserInput();

		Validator.validateBaseballNumber(userBaseballNumber);

		return userBaseballNumber;
	}

	public static String getUserGameProceedNumber() {
		String userGameProceed = getUserInput();

		Validator.validateGameProceedNumber(userGameProceed);

		return userGameProceed;
	}

	private static String getUserInput() {
		try {
			return Console.readLine();
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException(ERROR_NOTHING_CANT_BE_INPUT);
		}
	}
}
