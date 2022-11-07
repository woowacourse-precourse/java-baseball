package baseball.view;

import baseball.exception.InputExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String userNumber() {
		OutputView.printInputUserNumber();
		return InputExceptionHandler.checkNumberForm(Console.readLine());
	}

	public static String restartOrExit() {
		OutputView.printEndGame();
		return InputExceptionHandler.isRestartOrExitNumber(Console.readLine());
	}
}
