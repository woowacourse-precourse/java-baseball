package baseball.views;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Reader {
	public static String getUserBaseBallNumber() {
		String userBaseballNumber = Console.readLine();

		Validator.validateBaseballNumber(userBaseballNumber);

		return userBaseballNumber;
	}

	public static String getUserGameProceedNumber() {
		String userGameProceed;
		try {
			userGameProceed = Console.readLine();
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("[Error] 아무것도 아닌 입력은 입력이 될 수 없습니다.");
		}

		Validator.validateGameProceedNumber(userGameProceed);

		return userGameProceed;
	}
}
