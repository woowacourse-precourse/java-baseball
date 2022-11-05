package baseball;

import baseball.view.InputConsoleView;
import baseball.view.OutputConsoleView;

public class Application {
	public static void main(String[] args) {
		GameController gc = new GameController(new InputConsoleView(), new OutputConsoleView());
		gc.run();
	}
}