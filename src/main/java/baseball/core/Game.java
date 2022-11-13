package baseball.core;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Progress;

public class Game {
	public void start() {
		GameBuilder runner = new BaseballGameBuilder();
		Progress progressCode;

		do {
			Computer computer = new Computer();
			Player player = new Player();

			progressCode = runner.initGame(computer, player)
					.executeGame()
					.exitGame();

		} while (isContinued(progressCode));
	}

	private boolean isContinued(Progress progress) {
		return progress.isRestart();
	}
}
