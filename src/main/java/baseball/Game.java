package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final int DIGIT_NUMBER = 3;

	private boolean isContinue;

	public void play() {
		isContinue = true;
		Computer computer = new Computer();

		try {
			do {
				System.out.print(Message.INPUT_NUMBER_MESSAGE);
				User user = new User(Console.readLine());
				user.calculateBallAndStrike(computer.getRandomNumberList());
				checkGameResult(user);
			} while(isContinue);
		} catch (Exception e){
			System.out.println(Message.INVALID_ARGUMENT_EXCEPTION_MESSAGE);
			throw e;
		}
	}

	private void checkGameResult(User user) {
		printGameResult(user.getBall(), user.getStrike());

		if(user.getStrike() == DIGIT_NUMBER) {
			System.out.println(Message.GAME_OVER_MESSAGE);
			System.out.println(Message.INPUT_NEXT_STEP_MESSAGE);
			doNextStep(Console.readLine());
		}
	}

	private void printGameResult(int ball, int strike) {
		String ballResult = "";
		String strikeResult = "";

		if(ball > 0) {
			ballResult = ball + Message.BALL_MESSAGE;
		}

		if(strike > 0) {
			strikeResult = strike + Message.STRIKE_MESAGE;
		}

		if(ball == 0 && strike == 0) {
			System.out.println(Message.NOTHING_MESSAGE);
		} else {
			System.out.println(ballResult + " " + strikeResult);
		}
	}

	private void doNextStep(String input) {
		try {
			switch (NextStepInput.fromInputCode(input)) {
				case RESTART:
					play();
					isContinue = true;
				case END:
					System.out.print(Message.END_MESSAGE);
					isContinue = false;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(Message.INVALID_ARGUMENT_EXCEPTION_MESSAGE);
			throw e;
		}
	}
}
