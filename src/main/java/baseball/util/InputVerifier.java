package baseball.util;

import java.util.List;

public class InputVerifier {

	String input;

	public InputVerifier(String input) {
		this.input = input;
	}

	public boolean isInteger() {
		for (int i = 0; i < input.length(); i++) {
			char needVerify = input.charAt(i);

			if (!Character.isDigit(needVerify)) {
				return false;
			}
		}

		return true;
	}

	public boolean isSizeValid() {
		List<Integer> inputArray = StringToArrayList.convert(input);
		return inputArray.size() == 3;
	}

	public boolean notContainZero() {
		List<Integer> inputArray = StringToArrayList.convert(input);
		return !inputArray.contains(0);
	}

	public boolean isUnique() {
		List<Integer> inputArray = StringToArrayList.convert(input);
		return inputArray.size() == inputArray.stream().distinct().count();
	}
}
