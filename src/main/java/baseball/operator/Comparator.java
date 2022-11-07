package baseball.operator;

import static baseball.Constant.*;

import baseball.Computer;
import baseball.User;

public class Comparator {
	Computer computer;
	User user;

	public Comparator(Computer computer, User user) {
		this.computer = computer;
		this.user = user;
	}

	static int strikeCount = 0;
	static int ballCount = 0;

	public void printHintMessage() {
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println(NOTHING);
		}
		if (ballCount != 0 && strikeCount == 0) {
			System.out.println(ballCount + BALL);
		}
		if (strikeCount != 0 && ballCount == 0) {
			System.out.println(strikeCount + STRIKE);
		}
		if (strikeCount != 0 && strikeCount != NUM_LENGTH && ballCount != 0) {
			System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
		}
		if (strikeCount == NUM_LENGTH) {
			System.out.printf(WIN_MESSAGE);
			System.out.println(END_MESSAGE);
		}
	}

	public void setCounts() {
		for (int i = 0; i < NUM_LENGTH; i++) {
			if (!isStrike(i)) {
				isBall(i);
			}
		}
	}

	public void resetCounts() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public boolean isStrike(int index) {
		if (computer.answer.get(index).equals(user.numbers.get(index))) {
			strikeCount++;
			return true;
		}
		return false;
	}

	public boolean isBall(int index) {
		if (computer.answer.contains(user.numbers.get(index))) {
			ballCount++;
			return true;
		}
		return false;
	}

}
