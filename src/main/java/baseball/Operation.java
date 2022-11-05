package baseball;

public class Operation {
	public void start() {
		new Computer();
		GameView.printStartGame();
		guessNums();
		restart();
	}

	private static void guessNums() {
		do {
			User.getUserInput();
			Hint.searchHint();
		} while (!Hint.getRightAnswer());
	}

	private void restart() {
		if (User.isRestart()) {
			start();
		}
	}
}
