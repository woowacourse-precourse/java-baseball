package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.exception.InvalidInputException;

public class User {
	private static final String MIN_NUMBER = "1";
	private static final String MAX_NUMBER = "9";
	private static final int NUMBER_LENGTH = 3;
	private List<Integer> number;

	public User(List<Integer> number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(List<Integer> number) {
		validateNumberSize(number);
		validateDuplicate(number);
		validateDigitRange(number);
	}

	private void validateDuplicate(List<Integer> number) {
		Set<Integer> numSet = new HashSet<>(number);
		if (numSet.size() != NUMBER_LENGTH) {
			InvalidInputException.duplicateError();
		}
	}

	private void validateNumberSize(List<Integer> number) {
		if (number.size() != NUMBER_LENGTH) {
			InvalidInputException.sizeError();
		}
	}

	private void validateDigitRange(List<Integer> number) {
		String REGEX = String.format("[%s-%s]+", MIN_NUMBER, MAX_NUMBER);

		String str = number.stream()
			.map(n -> String.valueOf(n))
			.collect(Collectors.joining(""));

		if (!str.matches(REGEX)) {
			InvalidInputException.numberError();
		}
	}

}
