package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String TRY_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static String tryAnswerInput(){
		System.out.print(TRY_MESSAGE);
		return Console.readLine();
	}

	public static String restartInput(){
		System.out.println(RESTART_MESSAGE);
		return Console.readLine();
	}
}
