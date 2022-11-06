package baseball;

import baseball.view.InputViewConsole;
import baseball.view.OutputViewConsole;

public class Application {
	public static void main(String[] args) {
		GameController gc = new GameController(new InputViewConsole(), new OutputViewConsole());
		gc.run();
	}
}