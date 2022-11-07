package baseball;

public class Operation {
	private static Operation uniqueOperation = new Operation();

	private Operation() {
		GameView.printStartGame();
	}

	public static Operation getInstance() {
		return uniqueOperation;
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
