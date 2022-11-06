package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {
	String userInput;
	String patternedUserInput;
	String validatedUserInput;

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
}
