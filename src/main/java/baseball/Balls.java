package baseball;

import java.util.HashSet;
import java.util.List;

public class Balls {

	private static final int BALLS_SIZE = 3;

	public Balls(final List<Integer> numbers) {
		validateNumbers(numbers);
	}

	private void validateNumbers(final List<Integer> numbers) {
		if (!isValidSize(numbers) || isDuplicated(numbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isDuplicated(final List<Integer> numbers) {
		return new HashSet<>(numbers).size() != BALLS_SIZE;
	}

	private boolean isValidSize(final List<Integer> numbers) {
		return numbers.size() == BALLS_SIZE;
	}
}
