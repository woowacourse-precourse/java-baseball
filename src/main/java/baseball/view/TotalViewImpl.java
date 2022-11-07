package baseball.view;

import baseball.message.MessageConstants;
import baseball.restrict.RestrictIntegerConstants;

public class TotalViewImpl implements MessageConstants, RestrictIntegerConstants {

	public void printStartMessage() {
		System.out.print(START_MESSAGE);
	}

	public void printInputMessage() {
		System.out.print(INPUT_MESSAGE);
	}

	public void printStrikeMessage(int strikeCnt) {
		System.out.printf(STRIKE_MESSAGE_FORMAT, strikeCnt);
	}

	public void printBallMessage(int ballCnt) {
		System.out.printf(BALL_MESSAGE_FORMAT, ballCnt);
	}

	public void printBallAndStrikeMessage(int ballCnt, int strikeCnt) {
		System.out.printf(BALL_AND_STRIKE_MESSAGE_FORMAT, ballCnt, strikeCnt);
	}

	public void printNothingMessage() {
		System.out.print(NOTHING_MESSAGE);
	}

	public void printAnswerMessage() {
		System.out.printf(ANSWER_MESSAGE_FORMAT, LIMIT_LIST_SIZE);
	}

	public void printEndMessage() {
		System.out.printf(END_MESSAGE_FORMAT, RESTART_NUMBER, EXIT_NUMBER);
	}

}
