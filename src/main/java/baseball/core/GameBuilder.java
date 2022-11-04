package baseball.core;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Progress;

public interface GameBuilder {
	GameBuilder initGame(Computer computer, Player player);

	GameBuilder executeGame();

	Progress exitGame();
}
