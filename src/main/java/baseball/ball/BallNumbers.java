package baseball.ball;

import java.util.List;

public class BallNumbers {
	private static final int NUMBER_OF_BALLS = 3;

	private final List<BallNumber> ballNumbers;

	private BallNumbers(List<BallNumber> ballNumbers) {
		validateSize(ballNumbers);
		validateDuplicate(ballNumbers);

		this.ballNumbers = ballNumbers;
	}

	public static BallNumbers from(List<BallNumber> ballNumbers) {
		return new BallNumbers(ballNumbers);
	}

	private void validateSize(List<BallNumber> ballNumbers) {
		if (ballNumbers.size() != NUMBER_OF_BALLS) {
			throw new IllegalArgumentException("야구공의 개수가 3개 이상입니다.");
		}
	}

	private void validateDuplicate(List<BallNumber> ballNumbers) {
		if (ballNumbers.stream().distinct().count() != NUMBER_OF_BALLS) {
			throw new IllegalArgumentException("야구공의 숫자에 중복이 존재합니다.");
		}
	}
}
