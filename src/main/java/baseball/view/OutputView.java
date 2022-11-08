package baseball.view;

import baseball.game.Game;

public class OutputView {
	private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String LINE_BREAK = "%n";
	private static final String BLANK = " ";

	private static final String GAME_RESULT_NOTHING_MESSAGE = "낫싱";
	private static final String GAME_RESULT_STRIKE_COUNT_MESSAGE = "%d스트라이크";
	private static final String GAME_RESULT_BALL_COUNT_MESSAGE = "%d볼";
	private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void displayGameStartMessage() {
		System.out.println(START_GAME_MESSAGE);
	}

	public static void displayGameResult(Game game) {
		if (game.isNothing()) {
			System.out.println(GAME_RESULT_NOTHING_MESSAGE);

		} else if (game.isNoBall()) {
			System.out.printf(GAME_RESULT_STRIKE_COUNT_MESSAGE + LINE_BREAK, game.getStrikeCount());

		} else if (game.isNoStrike()) {
			System.out.printf(GAME_RESULT_BALL_COUNT_MESSAGE + LINE_BREAK, game.getBallCount());

		} else {
			System.out.printf(GAME_RESULT_BALL_COUNT_MESSAGE + BLANK + GAME_RESULT_STRIKE_COUNT_MESSAGE + LINE_BREAK,
				game.getBallCount(), game.getStrikeCount());
		}
	}

	public static void displayGameOverMessage() {
		System.out.println(GAME_OVER_MESSAGE);
	}
}
