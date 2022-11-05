package baseball.view;

public interface OutputView {
	void printGameStartMessage();

	void printInputMessage();

	void printRestartMessage();

	void print3StrikeMessage();

	void printBSOResult(int[] resultBSO);
}
