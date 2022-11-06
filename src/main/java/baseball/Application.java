package baseball;

import baseball.game.Game;
import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

public class Application {
	public static void main(String[] args) {
		PlayerComputer computer = PlayerComputer.getInstance();
		PlayerUser user = PlayerUser.getInstance();
		Game game = Game.getInstance();
		int replayOrEndGame;

		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			replayOrEndGame = game.play(computer, user);
		} while (replayOrEndGame != 2);
	}
}
