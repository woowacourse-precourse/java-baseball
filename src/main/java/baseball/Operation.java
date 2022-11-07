package baseball;

public class Operation {
	public Operation() {
		GameView.printStartGame();
	}

	public void start() {
		new Computer();
		guessNums();
		restart();
	}

	private static void guessNums() {
		do {
			User.getUserInput();
			Hint.searchHint();
		} while (!Hint.isRightAnswer());
	}

	private void restart() {
		if (User.isRestart()) {
			Computer.resetComputerNums();
			start();
		}
	}
}
