package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserBaseballNumber extends BaseballNumber {
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static final char ZERO_CHARACTER = '0';

	public UserBaseballNumber(String userInput) {
		userInputIsNotNull(userInput);
		inputHasOnlyNumber(userInput);

		List<Integer> inputNumbers = stringToIntegerList(userInput);
		checkValidation(inputNumbers);

		numbers = inputNumbers;
	}

	private void userInputIsNotNull(String userInput) {
		if (userInput == null)
			throw new IllegalArgumentException("입력한 값이 null입니다.");
	}

	private void inputHasOnlyNumber(String userInput) {
		if (!userInput.matches(NUMBER_PATTERN))
			throw new IllegalArgumentException("입력값에 수가 아닌 값이 있습니다.");
	}

	private List<Integer> stringToIntegerList(String userInput) {
		return userInput.chars().boxed().map(num -> num - ZERO_CHARACTER)
			.collect(Collectors.toList());
	}
}
