package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.Judgment;
import baseball.view.InputView;

public class BaseballGame {
	private final Computer computer;
	private final User user;
	private final Judgment judgment;

	public BaseballGame() {
		computer = new Computer();
		user = new User();
		judgment = new Judgment();
	}

	public void run() {
		computer.generateNumber();

		do {
			user.setNumber(InputView.userNumber());
			judgment.compareNumber(user.getNumber(), computer.getNumber());
		} while (judgment.threeStrike());
	}
}
