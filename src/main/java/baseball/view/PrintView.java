package baseball.view;

import baseball.domain.Computer;

public class PrintView {
	private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String BALL_MESSAGE = "%d볼\n";
	private static final String STRIKE_MESSAGE = "%d스트라이크\n";
	private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String WIN_GAME_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
	private static final String INPUT_RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printStartMessage() {
		System.out.println(START_GAME_MESSAGE);
	}

	public static void printHint(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			System.out.println(NOTHING_MESSAGE);
		} else if (ball == 0 && strike != 0) {
			System.out.printf(STRIKE_MESSAGE, strike);
		} else if (ball != 0 && strike == 0) {
			System.out.printf(BALL_MESSAGE, ball);
		} else if (ball != 0 && strike != 0) {
			System.out.printf(BALL_STRIKE_MESSAGE, ball, strike);
		}
	}

	public static void printEndGame() {
		System.out.printf(WIN_GAME_MESSAGE, Computer.ANSWER_LENGTH);
		System.out.println(INPUT_RESTART_OR_EXIT_MESSAGE);
	}

}
