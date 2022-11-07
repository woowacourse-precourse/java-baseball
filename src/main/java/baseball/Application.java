package baseball;

import baseball.game.Game;
import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

public class Application {
	private static final int REPLAY = 1;

	public static void main(String[] args) {
		int replayOrEndGame;

		PlayerComputer computer = PlayerComputer.getInstance();
		PlayerUser user = PlayerUser.getInstance();
		Game game = Game.getInstance();

		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			replayOrEndGame = game.play(computer, user);
		} while (replayOrEndGame == REPLAY);
	}
}
