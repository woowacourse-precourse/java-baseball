package Controller;

import static Controller.Printer.*;
import static Controller.Restarter.*;

public class Execution {
	public static void execute() {
		printGameStartMessage();
		do {
			Game game = new Game();
			game.play();
		} while (restart());

	}
}
