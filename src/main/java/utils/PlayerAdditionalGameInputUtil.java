package utils;

import camp.nextstep.edu.missionutils.Console;

public class PlayerAdditionalGameInputUtil {

	private PlayerAdditionalGameInputUtil() {

	}

	public static String readAdditionalGameQuestion() {
		String additionalGameState = Console.readLine();
		checkOtherInputException(additionalGameState);
		return additionalGameState;
	}

	public static void checkOtherInputException(String additionalGameState) {
		if (additionalGameState.equals("1")) {
			return;
		}
		if (additionalGameState.equals("2")) {
			return;
		}
		throw new IllegalArgumentException("잘못된 입력입니다. [1:게임 새로 시작 or 2:게임 종료] 만 입력해야 합니다.");
	}
}
