package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {

	private InputValidator inputValidator = new InputValidator();

	public void printInitMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public List<Integer> getInputList() {
		String ansString = Console.readLine(); // Console.readLine()은 단 한 줄의 입력만을 받는 게 맞는가?
		inputValidator.validateAnsString(ansString);
		List<Integer> inputList = new ArrayList<>(3);
		for (char c : ansString.toCharArray()) {
			inputList.add(c-'0');
		}
		return inputList;
	}

}
