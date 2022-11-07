package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;

public class RandomGenerator {

	public List<Integer> generateNumbers() {
		List<Integer> numbers = new LinkedList<>();
		return generateNumbers(numbers);
	}

	private List<Integer> generateNumbers(List<Integer> numbers) {
		if (numbers.size() == Constants.NUMBER_SIZE) {
			return numbers;
		}
		int number = generateNumber();
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
		return generateNumbers(numbers);
	}

	int generateNumber() {
		return Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
	}
}
