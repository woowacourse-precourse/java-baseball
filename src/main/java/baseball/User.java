package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
	String userInput;
	String patternedUserInput;
	String validatedUserInput;

	User() {}

	public void scanInput() {
		userInput = Console.readLine();
	}
}
