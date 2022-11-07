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
		guessAnswer();
		restart();
	}

	private static void guessAnswer() {
		do {
			User.putInput();
			Hint.search();
		} while (!Hint.isRightAnswer());
	}

	private void restart() {
		if (User.isRestart()) {
			Computer.resetComputerNums();
			start();
		}
	}
}
