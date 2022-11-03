package baseball.domain;

import baseball.view.GameView;

public class Game {
	private final Computer computer;
	private User user;

	public Game() {
		computer = new Computer();
	}

	public void play() {
		GameView.printStartMessage();
		computer.createAnswer();
		user = new User(GameView.inputNum());
	}
}
