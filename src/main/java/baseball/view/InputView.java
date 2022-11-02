package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";


	public static String userNumber() {
		System.out.print(INPUT_USER_NUMBER_MESSAGE);
		return InputException.checkNumberForm(Console.readLine());
	}

	public static String restartOrExit() {
		OutputView.printEndGame();
		return InputException.isRestartOrExitNumber(Console.readLine());
	}
}
