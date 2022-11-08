package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {

	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final int DIGIT_LENGTH = 3;

	private static List<Integer> injectNumber = new ArrayList<>();

	public void inputNumber() {
		System.out.print(INPUT_MESSAGE);
		String inputNumber = Valid.validInputNumber(readLine());
		injectNumber.clear();

		for (int index = 0; index < DIGIT_LENGTH; index++) {
			int digit = inputNumber.charAt(index) - '0';

			injectNumber.add(digit);
		}
	}

	public List<Integer> getInjectNumber() {
		return injectNumber;
	}

}
