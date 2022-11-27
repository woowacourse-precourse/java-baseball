package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		game.start(new Computer(), new Player());
	}
}
