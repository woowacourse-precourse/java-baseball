package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputData {

	public static final String NUMBER_OF_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	private InputData(){}

	public static String inputUserBallNumber() {
		System.out.print(NUMBER_OF_USER_INPUT_MESSAGE);
		return inputString();
	}

	private static String inputString(){
		return Console.readLine();
	}


}
