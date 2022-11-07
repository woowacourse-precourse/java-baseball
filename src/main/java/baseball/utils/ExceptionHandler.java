package baseball.utils;

import baseball.service.GameService;

public class ExceptionHandler {
	public static void checkUserException(String number) {
		checkNullError(number);
		isSame(number);

		for (int i = 0; i < number.length(); i++) {
			checkUserRange(Character.getNumericValue(number.charAt(i)));
		}
	}
	public static void isSame(String number) {
		String tmp = "";

		for (int i = 0; i < number.length(); i++) {
			if (GameService.checkSameNumber(tmp, Character.getNumericValue(number.charAt(i)))) {
				throw new IllegalArgumentException(Text.error.getPrint());
			}
			tmp += number.charAt(i);
		}
	}
	public static void checkUserRange(int userNumber) {
		if (userNumber < 1 || userNumber > 9) {
			throw new IllegalArgumentException(Text.error.getPrint());
		}
	}
	public static void checkNullError(String number) {
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
