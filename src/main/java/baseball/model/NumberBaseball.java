package baseball.model;

import java.util.List;

public class NumberBaseball {
	private final List<Integer> numbers;

	public NumberBaseball(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
