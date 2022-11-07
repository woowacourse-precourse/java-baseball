package baseball.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.message.MessageConstants;

public class BaseballGameUserInputFilterImpl implements UserInputFilter<Integer> {

	private static final String ERROR_MESSAGE = MessageConstants.USER_INPUT_ERROR_MESSAGE;

	@Override
	public boolean checkUserInput(String userInput, int size, Integer min, Integer max) throws IllegalStateException {
		List<Character> duplicateCheck = new ArrayList<>();

		if (userInput == null || userInput.length() != size) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		for (int userInputStringIndex = 0; userInputStringIndex < size; userInputStringIndex++) {
			char userNumber = userInput.charAt(userInputStringIndex);

			if (!('0' + min <= userNumber && userNumber <= '0' + max)) {
				throw new IllegalArgumentException(ERROR_MESSAGE);
			} else if (duplicateCheck.contains(userNumber)) {
				throw new IllegalArgumentException(ERROR_MESSAGE);
			} else {
				duplicateCheck.add(userNumber);
			}
		}
		return true;
	}

	@Override
	public List<Integer> bindingResult(String userInput, int size) {
		List<Integer> result = new ArrayList<>();

		if (userInput == null || userInput.length() < size) {
			return Collections.emptyList();
		}
		for (int userInputStringIndex = 0; userInputStringIndex < size; userInputStringIndex++) {
			int userNumber = userInput.charAt(userInputStringIndex) - '0';

			result.add(userNumber);
		}
		return result;
	}
}
