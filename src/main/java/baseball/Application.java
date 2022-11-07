package baseball;

import baseball.controller.Setup;
import baseball.model.game.Game;
import baseball.view.Output;

public class Application {
	public static Game game = new Game();

	public static void main(String[] args) {
		Output.print(Setup.START_MESSAGE.getValue());
		game.play();
	}
}
