package baseball.domail;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private static final String input = getInput();
	private static final List<Integer> inputToArray = getInputToArray();


	/*
	 * TODO: 유저 입력 값을 List로 변환해주는 메소드
	 * TODO: 유저 입력 값이 유효한지 확인하는 메소드 + 예외 메시지 출력
	 * TODO: 유저에게 입력을 받는 메소드
	 */

	private static List<Integer> getInputToArray() {
		List<Integer> inputToArray = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			int value = Character.getNumericValue(input.charAt(i));
			inputToArray.add(value);
		}

		return inputToArray;
	}

	private static String getInput() {
		return Console.readLine();
	}

}
