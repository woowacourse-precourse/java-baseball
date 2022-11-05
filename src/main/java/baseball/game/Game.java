package baseball.game;

import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

public class Game {
	private static final Game instance = new Game();


	private enum JudgeIndex {
		STRIKE, BALL
	}

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	public void play(PlayerComputer computer, PlayerUser user) {

	}


}
