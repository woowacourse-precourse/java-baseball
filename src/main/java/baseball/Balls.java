package baseball;

import java.util.List;

public class Balls {

	private static final int BALLS_SIZE = 3;

	public Balls(final List<Integer> numbers) {
		validateNumbers(numbers);
	}

	private void validateNumbers(final List<Integer> numbers) {
		if (!isValidSize(numbers)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isValidSize(final List<Integer> numbers) {
		return numbers.size() == BALLS_SIZE;
	}
}
