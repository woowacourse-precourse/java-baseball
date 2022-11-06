package baseball.service;

import baseball.Text;
import baseball.view.View;

public class ExceptionHandler {
	public static void checkException(String number) {
		checkNullException(number);
		isSameWord(number);

		for (int i = 0; i < number.length(); i++) {
			checkUserNumber(Character.getNumericValue(number.charAt(i)));
		}
	}
	public static void isSameWord(String number) {
		String tmp = "";

		for (int i = 0; i < number.length(); i++) {
			if (GameService.checkSameNumber(tmp, Character.getNumericValue(number.charAt(i)))) {
				throw new IllegalArgumentException(Text.error.getPrint());
			}
			tmp += number.charAt(i);
		}
	}
	public static void checkUserNumber(int userNumber) {
		if (userNumber < 1 || userNumber > 9) {
			throw new IllegalArgumentException(Text.error.getPrint());
		}
	}
	public static void checkNullException(String number) {
		if (number == null || number.isEmpty())
			throw new IllegalArgumentException(Text.error.getPrint());
		if (number.length() != 3)
			throw new IllegalArgumentException(Text.error.getPrint());
	}
}
