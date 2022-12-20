package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

	private static InputValidator inputValidator = new InputValidator();

	public List<Integer> getInputList() {
		String ansString = Console.readLine();
		inputValidator.validateAnsString(ansString);
		List<Integer> inputList = new ArrayList<>(3);
		for (char c : ansString.toCharArray()) {
			inputList.add(c - '0');
		}
		return inputList;
	}

	public int getRestartInt() {
		String restartString = Console.readLine();
		inputValidator.validateRestartString(restartString);
		return restartString.charAt(0) - '0';
	}
}
