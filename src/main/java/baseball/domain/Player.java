package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.util.StringToArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Player {

	private String input = getInput();

	private static final String ERROR_MESSAGE = "잘못된 값을 입력했습니다. 다시 입력해 주세요.";

	public Player() {

	}

	/*
	 * TODO: 유저 입력 값을 List로 변환해주는 메소드
	 * TODO: 유저 입력 값이 유효한지 확인하는 메소드 + 예외 메시지 출력
	 * TODO: 유저에게 입력을 받는 메소드
	 */

	public boolean isValid(String input) {
		this.input = input;
		return isInteger(input) && hasNoZero(input) && isThreeLength(input) && isUnique(input);
	}

	private boolean isInteger(String input) {
		this.input = input;

		for (int i = 0; i < input.length(); i++) {
			char check = input.charAt(i);

			if (Character.isDigit(check)) {
				return false;
			}
		}

		return true;
	}

	private boolean hasNoZero(String input) {
		this.input = input;
		List<Integer> inputArray = StringToArrayList.convert(input);

		for (Integer value : inputArray) {
			if (inputArray.contains(0)) {
				return false;
			}
		}

		return true;
	}

	private boolean isThreeLength(String input) {
		this.input = input;
		return input.length() == 3;
	}

	private boolean isUnique(String input) {
		this.input = input;
		List<Integer> inputArray = StringToArrayList.convert(input);

		for (Integer value : inputArray) {
			if (inputArray.contains(value)) {
				return false;
			}
		}

		return true;
	}

	private List<Integer> getInputToArray(String input) {
		this.input = input;
		List<Integer> inputToArray = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			int value = Character.getNumericValue(input.charAt(i));
			inputToArray.add(value);
		}

		return inputToArray;
	}

	private String getInput() {
		return Console.readLine();
	}

}
