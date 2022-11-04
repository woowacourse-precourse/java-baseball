package baseball;

public class Operation {
	public void start() {
		new Computer();
		GameView.printStartGame();
		guessNums();
	}

	private static void guessNums() {
		do {
			User.getUserInput();
			Hint.searchHint();
		} while (!Hint.getRightAnswer());
	}
}
