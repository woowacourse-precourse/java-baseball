package baseball;

import baseball.controller.NumberBaseballController;

public class Application {
	private static final NumberBaseballController numberBaseballController = new NumberBaseballController();
	public static void main(String[] args) {
		numberBaseballController.initGame();

		do {
			numberBaseballController.playBall();
		} while (numberBaseballController.restart());
	}
}
