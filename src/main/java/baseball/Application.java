package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		readBalls();
	}

	public static void readBalls() {
		String balls = Console.readLine();
		checkLessThanThreeExecption(balls);
	}

	public static void checkLessThanThreeExecption(String balls) {
		if (balls.length() < 3) {
			throw new IllegalArgumentException("잘못된 입력입니다. 공의 개수가 3개 보다 적습니다.");
		}
	}

	public static void checkMoreThanThreeException(String balls) {
		if (balls.length() > 3) {
			throw new IllegalArgumentException("잘못된 입력입니다. 공의 개수가 3개 보다 많습니다.");
		}
	}

	public static void checkNonNumericCharacterException(String balls) {
		for (char ball : balls.toCharArray()) {
			if (ball < '0' || '9' < ball) {
				throw new IllegalArgumentException("잘못된 입력입니다. 숫자가 아닌 입력이 존재합니다.");
			}
		}
	}
}
