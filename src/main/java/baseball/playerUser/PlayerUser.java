package baseball.playerUser;

import camp.nextstep.edu.missionutils.Console;

public class PlayerUser {
	private static final PlayerUser instance = new PlayerUser();

	private PlayerUser() {
	}

	public static PlayerUser getInstance() {
		return instance;
	}

	public String getInputNumber() throws IllegalArgumentException {
		String number = inputNumber();
//		String number = "123";

		if (isExceptionalInput(number)) {
			throw new IllegalArgumentException();
		}

		return number;
	}

	private String inputNumber() {
		return Console.readLine();
	}

	private boolean isExceptionalInput(String number) {
		return !isRightNumberSize(number) || !isPositiveNumber(number) || !isNoDuplicatedNumber(
			number);
	}

	private boolean isNoDuplicatedNumber(String number) {
		int numberSize = number.length();
		for (int i = 0; i < numberSize - 1; i++) {
			String subNumber = number.substring(i + 1);
			String digit = "" + number.charAt(i);
			if (subNumber.contains(digit)) {
				return false;
			}
		}
		return true;
	}

	private boolean isPositiveNumber(String number) {
		for (char elem : number.toCharArray()) {
			if (elem < '1' || elem > '9') {
				return false;
			}
		}
		return true;
	}

	private boolean isRightNumberSize(String number) {
		return number.length() == 3;
	}
}
