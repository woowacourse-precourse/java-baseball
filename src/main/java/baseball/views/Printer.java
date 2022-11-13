package baseball.views;

import static baseball.constants.Message.*;

public class Printer {

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
