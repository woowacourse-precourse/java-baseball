package baseball;

import baseball.controller.GameController;

public class Application {
	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		GameController gameController = new GameController();
		gameController.start();
		do {
			gameController.control();
		} while (gameController.hasRestartRequest());
	}
}