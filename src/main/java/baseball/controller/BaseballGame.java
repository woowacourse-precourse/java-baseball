package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.Judgment;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
	private final Computer computer;
	private final User user;
	private final Judgment judgment;
	private static final String RESTART = "1";

	public BaseballGame() {
		OutputView.printStartGameMessage();
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

		String input = InputView.restartOrExit();
		if (input.equals(RESTART)) {
			run();
		}
	}
}
