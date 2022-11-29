package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;

public class Application {
	public static void main(String[] args) {
		BaseBallGameProgram baseBallGameProgram = new BaseBallGameProgram(new Computer(), new Player());
		baseBallGameProgram.baseBallGame();
	}
}
