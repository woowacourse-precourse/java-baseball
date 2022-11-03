package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String TRY_MESSAGE = "숫자를 입력해주세요 : ";

	public static String tryAnswerInput(){
		System.out.print(TRY_MESSAGE);
		return Console.readLine();
	}
}
