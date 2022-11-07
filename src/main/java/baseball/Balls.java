package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private static final int BALL_NUMBERS_SIZE = 3;

	private final List<Ball> balls;

	public Balls(final List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
		this.balls = new ArrayList<>();
		initBalls(numbers);
	}

	private void initBalls(final List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			balls.add(new Ball(numbers.get(i), i+1));
		}
	}

	private void validateSize(final List<Integer> numbers) {
		if (numbers.size() != BALL_NUMBERS_SIZE) {
			throw new IllegalArgumentException("야구 번호는 3개만 가능합니다.");
		}
	}

	private void validateDuplicate(final List<Integer> numbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
		if (nonDuplicateNumbers.size() != BALL_NUMBERS_SIZE) {
			throw new IllegalArgumentException("야구 번호는 중복될 수 없습니다.");
		}
	}

	public BallStatus compareTo(final Ball other) {
		return balls.stream()
			.map(ball -> ball.compareTo(other))
			.filter(BallStatus::isStrikeOrBall)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}

	public PlayResult compareTo(final Balls other) {
		PlayResult result = new PlayResult();

		for (Ball ball : balls) {
			result.addStatus(other.compareTo(ball));
		}
		return result;
	}
}
