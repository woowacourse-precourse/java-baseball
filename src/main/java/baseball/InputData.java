package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputData {

	public static final String ENTER_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

	private InputData(){}

	public static String inputUserBallNumber() {
		System.out.print(ENTER_USER_NUMBER_MESSAGE);
		return inputString();
	}

	private static String inputString(){
		return Console.readLine();
	}


}
