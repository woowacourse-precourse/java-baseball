package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;

public class RandomGenerator {

	private static final int MAX_NUMBER = 9;
	private static final int MIN_NUMBER = 1;
	public static final int NUMBER_SIZE = 3;

	public List<Integer> generateNumbers() {
		List<Integer> numbers = new LinkedList<>();
		return generateNumbers(numbers);
	}

	private List<Integer> generateNumbers(List<Integer> numbers) {
		if (numbers.size() == NUMBER_SIZE) {
			return numbers;
		}
		int number = generateNumber();
		if (!numbers.contains(number)) {
			numbers.add(number);
		}
		return generateNumbers(numbers);
	}

	int generateNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
}
