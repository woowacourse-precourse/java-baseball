package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";


	public static String userNumber() {
		System.out.print(INPUT_USER_NUMBER_MESSAGE);
		return Console.readLine();
	}

	public static String restartOrExit() {
		OutputView.printEndGame();
		return Console.readLine();
	}
}
