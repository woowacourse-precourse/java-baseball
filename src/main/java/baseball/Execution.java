package baseball;

import static baseball.view.Printer.*;
import static baseball.controller.Restarter.*;

import baseball.controller.Game;

public class Execution {
	public static void execute() {
		printGameStartMessage();

		do {
			Game game = new Game();
			game.play();
		} while (restart());
	}
}
