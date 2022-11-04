package baseball.playerUser;

import camp.nextstep.edu.missionutils.Console;

public class PlayerUser {
	private static final PlayerUser instance = new PlayerUser();

	private PlayerUser() {
	}

	public static PlayerUser getInstance() {
		return instance;
	}

	private String inputNumber() {
		return Console.readLine();
	}

	private boolean isInputNumberException(String number) {
		return !isRightNumberSize(number) || !isPositiveNumber(number) || !isNoDuplicatedNumber(
			number);
	}

	private boolean isNoDuplicatedNumber(String number) {
	}

	private boolean isPositiveNumber(String number) {
		for (char elem : number.toCharArray()) {

		}
	}

	private boolean isRightNumberSize(String number) {
		return number.length() == 3;
	}

}
