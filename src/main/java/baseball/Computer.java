package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import static baseball.Configure.*;


public class Computer {


	public LinkedHashMap<Integer, Integer> getNumbers() {
		List<Integer> numberList = new ArrayList<>();
		createMultipleRandomNumber(numberList);

		return processNumbers(numberList);
	}

	public LinkedHashMap<Integer, Integer> processNumbers(List<Integer> input) {
		return storeIntoMap(input);
	}

	public LinkedHashMap<Integer, Integer> storeIntoMap(List<Integer> numbersArray) {

		LinkedHashMap<Integer, Integer> numbersWithIdx = new LinkedHashMap<>();

		for (int idx = 0; idx < numbersArray.size(); idx++) {
			numbersWithIdx.put(numbersArray.get(idx), idx);
		}

		return numbersWithIdx;
	}

	private void createMultipleRandomNumber(List<Integer> randomNumbers) {
		do {
			int createdNumber = createOneRandomNumber();

			if (!hasDuplication(randomNumbers, createdNumber)) {
				randomNumbers.add(createdNumber);
			}

		} while (!followDigitRule(randomNumbers));
	}

	private static boolean followDigitRule(List<Integer> randomNumber) {
		return Objects.equals(randomNumber.size(), NUMBER_DIGIT.getValue());
	}

	public boolean hasDuplication(List<Integer> randomNumber, int createdNumber) {
		return randomNumber.contains(createdNumber);
	}

	public int createOneRandomNumber() {
		return Randoms.pickNumberInRange(1, 9);
	}


}
