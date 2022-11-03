package baseball.model.numberbaseball;

import java.util.List;

public class NumberBaseball {
	private final List<Integer> numbers;

	public NumberBaseball(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getNumberAt(int index) {
		return numbers.get(index);
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
