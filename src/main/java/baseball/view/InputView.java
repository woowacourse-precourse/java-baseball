package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String userNumber() {
		OutputView.printInputUserNumber();
		return InputException.checkNumberForm(Console.readLine());
	}

	public static String restartOrExit() {
		OutputView.printEndGame();
		return InputException.isRestartOrExitNumber(Console.readLine());
	}
}
