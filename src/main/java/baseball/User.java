package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

	int ball;
	int strike;
	String num;
	String result;

	public void init() {
		ball = 0;
		strike = 0;
		result = "";
	}

	public void inputNum() {
		num = Console.readLine();
		checkException();
	}

	public void calResult() {
		if (ball != 0 && strike != 0) {
			result = ball + "볼" + " " + strike + "스트라이크";
			return;
		}
		if (ball != 0) {
			result = ball + "볼";
			return;
		}
		if (strike != 0) {
			result = strike + "스트라이크";
			return;
		}
		if (result.isEmpty()) {
			result = "낫싱";
		}
	}

	public String getResult() {
		return result;
	}

	private void checkException() {
		if (num.length() > 3) {
			throw new IllegalArgumentException();
		}

		for (int index = 0; index < num.length(); index++) {
			if (num.charAt(index) < '1' || num.charAt(index) > '9') {
				throw new IllegalArgumentException();
			}
		}
	}
}
