package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;

public class Application {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.start(new Computer(), new Player());
	}
}
