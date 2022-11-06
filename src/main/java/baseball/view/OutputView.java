package baseball.view;

import static baseball.Constant.*;

import baseball.Constant;

public class OutputView {
	public static void gameStart() {
		System.out.println(START_MESSAGE);
	}

	public static void alertInputAnswer() {
		System.out.print(ALERT_INPUT_ANSWER_MESSAGE);
	}

	public static void printGuessResult(int strike, int ball) {
		if(ball == 0 && strike == 0) {
			System.out.println(GUESS_RESULT_NOTHING_MESSAGE);
			return;
		}
		if(ball > 0) {
			System.out.printf(GUESS_RESULT_BALL_MESSAGE, ball);
		}
		if(strike > 0) {
			System.out.printf(GUESS_RESULT_STRIKE_MESSAGE, strike);
		}
		System.out.println();
	}

	public static void printSuccessResult() {
		System.out.println(SUCCESS_RESULT_MESSAGE);
	}

	public static void askRestart() {
		System.out.println(RESTART_QUESTION_MESSAGE);
	}
}
