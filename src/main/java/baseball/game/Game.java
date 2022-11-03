package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import static baseball.game.Const.*;

public class Game {
	private final User user;
	private final Computer computer;
	private Score score;

	private Game(Computer computer, User user) {
		System.out.println(GAME_START_MESSAGE);
		this.computer = computer;
		this.user = user;
	}

	public static Game create() {
		return new Game(new Computer(), new User());
	}

	public void start() {
		init();
		loop();
	}

	private void init() {
		computer.generateNumbers();
		user.receiveUserInput(receiveInput(GAME_INPUT_WAIT_MESSAGE));
		score = Score.calculate(computer.getNumbers(), user.getNumbers());
	}

	private String receiveInput(String message) {
		System.out.println(message);
		return Console.readLine();
	}

	private void loop() {
		while (true) {
			if (isGameOver()) {
				return;
			}
			user.receiveUserInput(receiveInput(GAME_INPUT_WAIT_MESSAGE));
			score = Score.calculate(computer.getNumbers(), user.getNumbers());
		}
	}

	private boolean isGameOver() {
		if (score.isWin()) {
			System.out.println(GAME_WIN_MESSAGE);
			return !restartOrExit();
		}
		return false;
	}

	private boolean restartOrExit() {
		String input = receiveInput(GAME_RESTART_MESSAGE);
		if (input.equals("1")) {
			computer.generateNumbers();
			score.invalidate();
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException(GAME_EXCEPTION_RESTART_MESSAGE);
	}
}
