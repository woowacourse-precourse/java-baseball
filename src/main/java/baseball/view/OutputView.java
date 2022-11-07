package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final int ZERO_NUMBER = 0;
	private final GameResult result;

	public OutputView(GameResult result) {
		this.result = result;
	}

	public void printGameResult() {
		printAllBall();
		printAllStrike();
		printNothing();
		printBallAndStrike();
	}

	public static void printStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static void printClearMessage() {
		System.out.println(GAME_CLEAR_MESSAGE);
	}

	private void printAllBall() {
		if (result.ballCount != ZERO_NUMBER && result.strikeCount == ZERO_NUMBER) {
			System.out.println(result.ballCount + BALL_MESSAGE);
		}
	}

	private void printAllStrike() {
		if (result.ballCount == ZERO_NUMBER && result.strikeCount != ZERO_NUMBER) {
			System.out.println(result.strikeCount + STRIKE_MESSAGE);
		}
	}

	private void printBallAndStrike() {
		if (result.ballCount != ZERO_NUMBER && result.strikeCount != ZERO_NUMBER) {
			System.out.println(result.ballCount + BALL_MESSAGE + result.strikeCount + STRIKE_MESSAGE);
		}
	}

	private void printNothing() {
		if (result.ballCount == ZERO_NUMBER && result.strikeCount == ZERO_NUMBER) {
			System.out.println(NOTHING_MESSAGE);
		}
	}
}
