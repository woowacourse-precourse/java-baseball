package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;

public class User {
	String userInput;
	String patternedUserInput;
	List<Integer> validatedUserInput;

	User() {}

	public void scanInput() {
		userInput = Console.readLine();
	}

	public void patternValidateInput() {
		if (!Pattern.matches("^[1-9]{3}$?", userInput)) {
			throw new IllegalArgumentException();
		}

		patternedUserInput = userInput;
	}

	public void duplicationValidateInput() {
		initValidatedUserInput();

		for (int indexNumber = 0; indexNumber < 3; indexNumber++) {
			char charAtIndex = patternedUserInput.charAt(indexNumber);
			int intIndex = Character.getNumericValue(charAtIndex);

			if (validatedUserInput.contains(intIndex)) {
				throw new IllegalArgumentException();
			}

			validatedUserInput.add(intIndex);
		}
	}

	public void initValidatedUserInput() {
		validatedUserInput.clear();
	}
}
