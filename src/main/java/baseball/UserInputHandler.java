package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

	public static int inputNum() {
		String input = Console.readLine();

		if (input.length() != HintMaking.END_IDX) {
			ExceptionHandler.notMatchDigits();
		}

		for (int digit = HintMaking.START_IDX; digit < HintMaking.END_IDX; digit++) {
			if (input.charAt(digit) == '0') {
				ExceptionHandler.existenceZero();
			}
		}

		int num = Integer.parseInt(input);
		int hundreds = num / 100;
		int tens = (num % 100) / 10;
		int units = num % 100 % 10;

		if (AnswerChecking.isSameNumber(hundreds, tens, units)) {
			ExceptionHandler.duplicateNumber();
		}

		return num;
	}

}
