package baseball;

import static baseball.InputValidation.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String GET_BALL_NUMBERS = "숫자를 입력해주세요 : ";

	private static final String GET_GAME_OPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String getBallNumbers() {
		System.out.print(GET_BALL_NUMBERS);
		String ballNumbers = Console.readLine();
		validateInput(ballNumbers);
		return ballNumbers;
	}

	public static int getGameOption() {
		System.out.println(GET_GAME_OPTION);
		String gameOption = Console.readLine();
		validateOption(gameOption);
		return Integer.parseInt(gameOption);
	}
}
