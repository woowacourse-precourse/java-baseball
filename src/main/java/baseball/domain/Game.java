package baseball.domain;


public class Game {
	private final Computer computer;

	public Game() {
		computer = new Computer();
	}

	public void play() {
		computer.createAnswer();
	}
}
