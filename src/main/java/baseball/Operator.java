package baseball;

import static baseball.Constant.*;

public class Operator {
	Computer computer;
	User user;

	public Operator() {
		System.out.println(START_MESSAGE);
		Computer computer = new Computer();
		User user = new User();
	}

	public String checkStrike() {
		int count = 0;
		for (int i = 0; i < NUM_LENGTH; i++) {
			if (computer.answer.get(i) == user.numbers.get(i)) {
				count++;
			}
		}
		return count + STRIKE;
	}

	public String checkBall() {
		int ball = 0;
		for (int i = 0; i < NUM_LENGTH; i++) {
			if (user.numbers.get(i) != computer.answer.get(i) && computer.answer.contains(user.numbers.get(i))) {
				ball++;
			}
		}
		return ball + BALL;
	}

	// public static void requestRestart(){
	//
	// }

}
