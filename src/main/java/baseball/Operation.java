package baseball;

public class Operation {
	public void start() {
		new Computer();
		GameView.printStartGame();
		do {
			User.getUserInput();
			Hint.searchHint();
		} while (!Hint.getRightAnswer());
	}
}
