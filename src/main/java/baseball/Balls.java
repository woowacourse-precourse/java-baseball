package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

	private static final int BALLS_SIZE = 3;

	private final List<Ball> balls;

	public Balls(final List<Integer> numbers) {
		validateNumbers(numbers);
		this.balls = new ArrayList<>();
		initBalls(numbers);
	}

	private void initBalls(final List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			balls.add(new Ball(numbers.get(i), i+1));
		}
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

	public BallStatus compareTo(final Ball other) {
		return balls.stream()
			.map(ball -> ball.compareTo(other))
			.filter(BallStatus::isStrikeOrBall)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}

	public PlayResult compareTo(final Balls other) {
		return new PlayResult();
	}
}
