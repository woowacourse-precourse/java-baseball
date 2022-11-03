package baseball.operator;

import static baseball.Constant.*;

import baseball.Computer;
import baseball.User;
import camp.nextstep.edu.missionutils.Console;

public class Operator {

	User user = new User();
	Computer computer = new Computer();
	Comparator comparator = new Comparator(computer, user);
	boolean checkGameOver = false;

	public void run() {

		checkGameOver = false;
		System.out.println(START_MESSAGE);

		do {
			gameSystem();
		} while (!checkGameOver);

	}

	public void gameSystem() {
		user.play();
		comparator.setCounts();
		comparator.printHintMessage();
		checkGameIsOver();
		comparator.resetCounts();
	}

	public void checkGameIsOver() {
		if (Comparator.strikeCount == NUM_LENGTH) {
			this.checkGameOver = true;
		}
	}

	public boolean requestRestart() {
		String request;
		System.out.println(RESTART_REQUEST);
		request = Console.readLine();
		isValidate(request);

		return request.equals(RESTART_GAME);
	}

	private void isValidate(String request) {
		if (!request.equals(RESTART_GAME) && !request.equals(END_GAME)) {
			throw new IllegalArgumentException();
		}
	}

}
