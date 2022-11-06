package baseball;

import baseball.controller.NumberBaseballGame;
import baseball.model.numberbaseball.application.NumberBaseballService;
import baseball.view.NumberBaseballView;

public class Application {
	public static void main(String[] args) {
		final NumberBaseballService numberBaseballService = new NumberBaseballService();
		final NumberBaseballView numberBaseballView = new NumberBaseballView();

		final NumberBaseballGame numberBaseballGame = new NumberBaseballGame(
			numberBaseballView,
			numberBaseballService
		);

		numberBaseballGame.initGame();
		do {
			numberBaseballGame.playBall();
		} while (numberBaseballGame.restart());
	}
}
