package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.exception.InvalidInputException;

public class User {
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
		if (numSet.size() != Computer.ANSWER_LENGTH) {
			InvalidInputException.duplicateError();
		}
	}

	private void validateNumberSize(List<Integer> number) {
		if (number.size() != Computer.ANSWER_LENGTH) {
			InvalidInputException.sizeError();
		}
	}

	private void validateDigitRange(List<Integer> number) {
		String REGEX = String.format("[%s-%s]+", Computer.MIN_NUMBER, Computer.MAX_NUMBER);

		String str = number.stream()
			.map(n -> String.valueOf(n))
			.collect(Collectors.joining(""));

		if (!str.matches(REGEX)) {
			InvalidInputException.numberError();
		}
	}

	public List<Integer> getNumber() {
		return number;
	}
}
