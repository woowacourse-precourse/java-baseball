package baseball.domain;

import java.util.LinkedList;
import java.util.List;

public class Balls {

	private List<Ball> balls;

	public Balls(String inputString) {
		validateSize(inputString.length());
		List<Integer> numbers = mapToList(inputString);
		new Balls(numbers);
	}

	public Balls(List<Integer> numbers) {
		validateBalls(numbers);
		balls = mapToBalls(numbers);
	}

	private List<Integer> mapToList(String inputString) {
		List<Integer> numbers = new LinkedList<>();
		for (int index = 0; index < inputString.length(); index++) {
			numbers.add(Character.getNumericValue(inputString.charAt(index)));
		}
		return numbers;
	}


	private void validateBalls(List<Integer> numbers) {
		validateSize(numbers.size());
		validateDuplicate(numbers);
	}

	private void validateSize(int size) {
		if (size != Constants.NUMBER_SIZE) {
			throw new IllegalArgumentException("공은 서로 다른 3개의 수로 구성되어야 합니다.");
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		int number1 = numbers.get(0);
		int number2 = numbers.get(1);
		int number3 = numbers.get(2);
		if (number1 == number2 || number1 == number3 || number2 == number3) {
			throw new IllegalArgumentException("공은 서로 다른 3개의 수로 구성되어야 합니다.");
		}
	}

	private List<Ball> mapToBalls(List<Integer> numbers) {
		List<Ball> list = new LinkedList<>();
		for (int index = 0; index < numbers.size(); index++) {
			list.add(new Ball(numbers.get(index), index));
		}
		return list;
	}
}
