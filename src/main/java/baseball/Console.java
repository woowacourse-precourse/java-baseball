package baseball;

import static util.GameUtil.GAME_BALL_MESSAGE;
import static util.GameUtil.GAME_INPUT_MESSAGE;
import static util.GameUtil.GAME_NO_MESSAGE;
import static util.GameUtil.GAME_START_MESSAGE;
import static util.GameUtil.GAME_STLIKE_MESSAGE;

public class Console {

	public static void startMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static String inputUserBalls() {
		System.out.print(GAME_INPUT_MESSAGE);
		String userBalls = camp.nextstep.edu.missionutils.Console.readLine();
		Exception.check(userBalls);

		return userBalls;
	}

	public static void printHint(int strike, int ball) {
		String hintMessage = "";

		if (ball > 0 && strike > 0) {
			hintMessage = ball + GAME_BALL_MESSAGE + " " + strike + GAME_STLIKE_MESSAGE;
		} else if (strike > 0) {
			hintMessage = strike + GAME_STLIKE_MESSAGE;
		} else if (ball > 0) {
			hintMessage = ball + GAME_BALL_MESSAGE;
		} else if (strike == 0 && ball == 0) {
			hintMessage = GAME_NO_MESSAGE;
		}

		System.out.println(hintMessage);
	}
}
