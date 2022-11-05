package baseball;

import java.util.Arrays;

import baseball.domain.BaseballGameCalculator;
import baseball.domain.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static final int[] STRIKE_3 = {0, 3};
	private final InputView iv;
	private final OutputView ov;

	public GameController(InputView iv, OutputView ov) {
		this.iv = iv;
		this.ov = ov;
	}

	public void run() {
		do {
			startGame();
			ov.printRestartMessage();
		} while (iv.getRestartOrEndCode().equals("1"));
	}

	private void startGame() {
		ov.printGameStartMessage();
		BaseballNumber computer = BaseballNumber.createBaseballNumberByRandom();
		int[] result;

		do {
			ov.printInputMessage();
			BaseballNumber user = BaseballNumber.createBaseballNumberByUserInput(iv.getUserBaseballNumber());
			result = BaseballGameCalculator.calculateBSO(computer, user);
			ov.printBSOResult(result);
		} while (!Arrays.equals(result, STRIKE_3));

		ov.print3StrikeMessage();
	}
}
