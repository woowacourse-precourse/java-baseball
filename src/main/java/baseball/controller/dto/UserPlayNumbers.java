package baseball.controller.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.model.NumberBaseball;
import baseball.util.UserInputValidator;

public class UserPlayNumbers {
	private final String userInputNumbers;

	public UserPlayNumbers(String userInputNumbers) {
		UserInputValidator.validatePlayNumbers(userInputNumbers);
		this.userInputNumbers = userInputNumbers;
	}

	public String getUserInputNumbers() {
		return userInputNumbers;
	}

	public NumberBaseball toNumberBaseball() {
		String[] splitNumbers = userInputNumbers.split("");
		List<Integer> numbers = Arrays.stream(splitNumbers)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		return new NumberBaseball(numbers);
	}
}
