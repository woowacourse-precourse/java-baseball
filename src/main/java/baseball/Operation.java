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
		Computer com = new Computer();
		com.generateRandomThreeNums();
		guessAnswer();
		restart();
	}

	private static void guessAnswer() {
		do {
			User.inputNumber();
			Hint.search();
		} while (!Hint.isRightAnswer());
	}

	private void restart() {
		if (User.isRestart()) {
			start();
		}
	}
}
