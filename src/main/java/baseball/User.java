package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
	String userInput;
	String patternedUserInput;
	List<Integer> validatedUserInput = new ArrayList<>();

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
		if(validatedUserInput.size() > 0) {
			validatedUserInput.clear();
		}
	}

	public void scanInputWhenPlaying() {
		initValidatedUserInput();
		scanInput();
		patternValidateInput();
		duplicationValidateInput();
	}

	public void answerValidateInput() {
		initValidatedUserInput();

		if(!Pattern.matches("^[1-2]$?", userInput)) {
			throw new IllegalArgumentException();
		}

		validatedUserInput.add(Integer.parseInt(userInput));
	}

	public void scanInputWhenTerminating() {
		initValidatedUserInput();
		scanInput();
		answerValidateInput();
	}

	public void scanInputByStatus(String status) {
		if(status.equals("PLAYING")) {
			scanInputWhenPlaying();
		}
		if(status.equals("TERMINATING")) {
			scanInputWhenTerminating();
		}
	}
}
