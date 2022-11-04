package baseball.testhelper;

import java.util.ArrayList;
import java.util.List;

public enum ComparingResultExample {
	RANDOM_NUMBER(4, 5, 6),
	ONE_BALL(1, 2, 4),
	TWO_BALL(1, 4, 5),
	THREE_BALL(5, 6, 4),
	ONE_STRIKE(1, 2, 6),
	TWO_STRIKE(1, 5, 6),
	THREE_STRIKE(4, 5, 6),
	ONE_BALL_ONE_STRIKE(1, 5, 4),
	TWO_BALL_ONE_STRIKE(6, 5, 4),
	NOTHING(1, 2, 3);

	private final List<Integer> numbers = new ArrayList<>();

	ComparingResultExample(int n1, int n2, int n3) {
		this.numbers.addAll(List.of(n1, n2, n3));
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
