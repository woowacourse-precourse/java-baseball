package baseball.views;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Reader {
	public static String getUserBaseBallNumber() {
		String userBaseballNumber = Console.readLine();

		Validator.validateBaseballNumber(userBaseballNumber);

		return userBaseballNumber;
	}
}
