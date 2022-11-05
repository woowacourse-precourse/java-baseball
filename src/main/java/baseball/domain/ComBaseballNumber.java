package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComBaseballNumber extends BaseballNumber {
	public ComBaseballNumber() {
		List<Integer> randomNumbers = setRandomNumbers();
		checkValidation(randomNumbers);
		numbers = randomNumbers;
	}

	private List<Integer> setRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();
		while (randomNumbers.size() < DIGIT) {
			int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
			if (!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
		}
		return randomNumbers;
	}
}
