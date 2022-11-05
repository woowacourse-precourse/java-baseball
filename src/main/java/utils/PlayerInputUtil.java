package utils;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInputUtil {
	public static void readBalls() {
		String balls = Console.readLine();
		checkLessThanThreeExecption(balls);
		checkMoreThanThreeException(balls);
		checkNonNumericCharacterException(balls);
		checkDuplicateBallsException(balls);
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

	public static void checkDuplicateBallsException(String balls) {
		if (isExistsDuplicateBalls(balls)) {
			throw new IllegalArgumentException("잘못된 입력입니다. 중복된 공이 존재합니다.");
		}
	}

	private static boolean isExistsDuplicateBalls(String balls) {
		Set<Character> uniqueBalls = new HashSet<>();
		for (char ball : balls.toCharArray()) {
			if (uniqueBalls.contains(ball)) {
				return true;
			}
			uniqueBalls.add(ball);
		}
		return false;
	}
}
