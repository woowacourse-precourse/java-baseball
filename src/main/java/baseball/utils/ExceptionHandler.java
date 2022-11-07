package baseball.utils;

import baseball.service.BaseballService;

public class ExceptionHandler {
	public static void checkUserException(String number) {
		checkLengthException(number);
		isSameNumber(number);

		for (int i = 0; i < number.length(); i++) {
			checkUserRange(Character.getNumericValue(number.charAt(i)));
		}
	}

	public static void isSameNumber(String number) {
		String tmp = "";

		for (int i = 0; i < number.length(); i++) {
			if (BaseballService.checkSameNumber(tmp, Character.getNumericValue(number.charAt(i)))) {
				throw new IllegalArgumentException(Text.error.getPrint());
			}
			tmp += number.charAt(i);
		}
	}

	public static void checkUserRange(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException(Text.error.getPrint());
		}
	}

	public static void checkLengthException(String number) {
		if (number == null || number.isEmpty())
			throw new IllegalArgumentException(Text.error.getPrint());
		if (number.length() != 3)
			throw new IllegalArgumentException(Text.error.getPrint());
	}

	public static void checkStopException(String stop) {
		if (!(stop.equals("1") || stop.equals("2"))) {
			throw new IllegalArgumentException(Text.error.getPrint());
		}
	}
}
