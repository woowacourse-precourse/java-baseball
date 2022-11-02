package baseball.views;

public class Printer {
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String EMPTY = "";
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String ENTER_THE_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String GAME_ENDING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String GAME_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static void printPlzEnterTheBaseballNumberMessage() {
		System.out.print(ENTER_THE_BASEBALL_NUMBER_MESSAGE);
	}

	public static void printHintNothingMessage() {
		System.out.println(NOTHING_MESSAGE);
	}

	public static void printHintCountMessage(int ballCnt, int strikeCnt) {
		String ballHintMessage = getHintCountMessage(BALL_MESSAGE, ballCnt);
		String strikeHintMessage = getHintCountMessage(STRIKE_MESSAGE, strikeCnt);
		String hintMessage = ballHintMessage + strikeHintMessage;

		System.out.println(hintMessage);
	}

	public static void printGameEndingMessage() {
		System.out.println(GAME_ENDING_MESSAGE);
	}

	public static void printGameContinueQuestionMessage() {
		System.out.println(GAME_CONTINUE_MESSAGE);
	}

	private static String getHintCountMessage(final String MESSAGE, int count) {
		if (count == 0) {
			return EMPTY;
		}

		return count + MESSAGE;
	}
}
