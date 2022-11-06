package baseball;

import static baseball.view.OutputView.*;

import baseball.controller.GameController;
import baseball.controller.RestartController;

public class Application {
	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		RestartController restartController = new RestartController();
		printGameStartMessage();
		do {
			GameController gameController = new GameController();
			gameController.control();
		} while (restartController.restart());
	}
}