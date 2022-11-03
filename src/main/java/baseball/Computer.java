package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.Configure.*;


public class Computer {


	public List<Integer> getComputerNumber() {
		List<Integer> numberList = new ArrayList<>();
		createMultipleRandomNumber(numberList);
		return numberList;
	}

	private void createMultipleRandomNumber(List<Integer> randomNumber) {
		do {
			int createdNumber = createOneRandomNumber();

			if (!hasDuplication(randomNumber, createdNumber)) {
				randomNumber.add(createdNumber);
			}

		} while (!isSatisfyDigitRule(randomNumber));
	}

	private static boolean isSatisfyDigitRule(List<Integer> randomNumber) {
		return Objects.equals(randomNumber.size(), NUMBER_DIGIT.getValue());
	}

	public boolean hasDuplication(List<Integer> randomNumber, int createdNumber) {
		return randomNumber.contains(createdNumber);
	}

	public int createOneRandomNumber() {
		return Randoms.pickNumberInRange(1, 9);
	}


}
