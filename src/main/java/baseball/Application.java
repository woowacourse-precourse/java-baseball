package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;

public class Application {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame(new Computer(), new Player());
		baseBallGame.start();
	}
}
