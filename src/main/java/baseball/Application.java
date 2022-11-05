package baseball;

import baseball.view.InputViewImpl;
import baseball.view.OutputViewImpl;

public class Application {
	public static void main(String[] args) {
		GameController gc = new GameController(new InputViewImpl(), new OutputViewImpl());
		gc.run();
	}
}