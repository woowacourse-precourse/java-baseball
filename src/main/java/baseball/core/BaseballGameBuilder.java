package baseball.core;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Progress;

public class BaseballGameBuilder implements GameBuilder {
	private Computer computer;
	private Player player;

	@Override
	public GameBuilder initGame(Computer computer, Player player) {
		this.computer = computer;
		this.player = player;

		return this;
	}

	@Override
	public GameBuilder executeGame() {
		return this;
	}

	@Override
	public Progress exitGame() {
		return null;
	}
}
