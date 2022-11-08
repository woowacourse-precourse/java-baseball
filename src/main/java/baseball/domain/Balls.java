package baseball.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Balls {

	private List<BallNumber> balls;

	public Balls(String inputString) {
		validateString(inputString);
		List<Integer> numbers = mapToList(inputString);
		validateBalls(numbers);
		balls = mapToBalls(numbers);
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
			throw new IllegalArgumentException(Constants.BALLS_VALIDATE_ERR_MSG);
		}
	}

	private void validateString(String inputNumbers) {
		Pattern pattern = Pattern.compile(Constants.NUMBERS_REGEX);
		Matcher matcher = pattern.matcher(inputNumbers);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(Constants.BALLS_STRING_ERR_MSG);
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		int number1 = numbers.get(0);
		int number2 = numbers.get(1);
		int number3 = numbers.get(2);
		if (isDuplicate(number1, number2, number3)) {
			throw new IllegalArgumentException(Constants.BALLS_VALIDATE_ERR_MSG);
		}
	}

	private boolean isDuplicate(int number1, int number2, int number3) {
		return number1 == number2 || number1 == number3 || number2 == number3;
	}

	private List<BallNumber> mapToBalls(List<Integer> numbers) {
		List<BallNumber> list = new LinkedList<>();
		for (Integer number : numbers) {
			list.add(new BallNumber(number));
		}
		return list;
	}

	List<BallStatus> compare(Balls otherBalls) {
		List<BallStatus> result = new LinkedList<>();
		for (int index = 0; index < Constants.NUMBER_SIZE; index++) {
			result.add(compare(otherBalls.balls.get(index), index));
		}
		return result;
	}

	BallStatus compare(BallNumber otherBallNumber, int otherBallIndex) {
		if (balls.get(otherBallIndex).equals(otherBallNumber)) {
			return BallStatus.STRIKE;
		}
		if (balls.contains(otherBallNumber)) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}
}
