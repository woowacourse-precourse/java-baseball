package baseball.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public static BallNumbers convertUserInputToBallNumbers(char[] userInput) {
		List<BallNumber> ballNumbers = new ArrayList<>();

		for (char input : userInput) {
			ballNumbers.add(BallNumber.from(Character.getNumericValue(input)));
		}

		return BallNumbers.from(ballNumbers);
	}

	public int getBallNumberByIndex(int index) {
		return ballNumbers.get(index).getNumber();
	}

	public List<Integer> getAllBallNumber() {
		return ballNumbers.stream()
			.map(BallNumber::getNumber)
			.collect(Collectors.toList());
	}
}
