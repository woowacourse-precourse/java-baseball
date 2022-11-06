package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

	public static String receiveInput() {
		return Console.readLine();
	}

	public static void printPickUserBalls() {
		System.out.print("숫자를 입력해주세요 : ");
	}

}
