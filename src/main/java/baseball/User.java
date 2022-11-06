package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
	static final int MIN_PATTERN_VALUE_ON_PLAYING = 1;
	static final int MAX_PATTERN_VALUE_ON_PLAYING = 9;
	static final int MAX_NUMBERS_COUNT = 3;
	static final int MIN_PATTERN_VALUE_ON_RESTARTING = 1;
	static final int MAX_PATTERN_VALUE_ON_RESTARTING = 2;
	static final int MIN_LIST_SIZE = 0;
	static final int MIN_LIST_INDEX = 0;
	static final int MAX_LIST_INDEX = 3;

	static final String PATTERN_ON_PLAYING =	"^[" + MIN_PATTERN_VALUE_ON_PLAYING +
												"-" + MAX_PATTERN_VALUE_ON_PLAYING +
												"]{" + MAX_NUMBERS_COUNT + "}?$";
	static final String PATTERN_ON_RESTARTING =	"^[" + MIN_PATTERN_VALUE_ON_RESTARTING +
												"-" + MAX_PATTERN_VALUE_ON_RESTARTING + "]?$";
	static final String STATUS_PLAYING = "PLAYING";
	static final String STATUS_TERMINATING = "TERMINATING";
	String userInput;
	String patternedUserInput;
	List<Integer> validatedUserInput = new ArrayList<>();

	User() {}

	public void scanInput() {
		userInput = Console.readLine();
	}

	public void patternValidateInput() {
		if (!Pattern.matches(PATTERN_ON_PLAYING, userInput)) {
			throw new IllegalArgumentException();
		}

		patternedUserInput = userInput;
	}

	public void duplicationValidateInput() {
		initValidatedUserInput();

		for (int indexNumber = MIN_LIST_INDEX; indexNumber < MAX_LIST_INDEX; indexNumber++) {
			char charAtIndex = patternedUserInput.charAt(indexNumber);
			int intIndex = Character.getNumericValue(charAtIndex);

			if (validatedUserInput.contains(intIndex)) {
				throw new IllegalArgumentException();
			}

			validatedUserInput.add(intIndex);
		}
	}

	public void initValidatedUserInput() {
		if(validatedUserInput.size() > MIN_LIST_SIZE) {
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

		if(!Pattern.matches(PATTERN_ON_RESTARTING, userInput)) {
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
		if(status.equals(STATUS_PLAYING)) {
			scanInputWhenPlaying();
		}
		if(status.equals(STATUS_TERMINATING)) {
			scanInputWhenTerminating();
		}
	}

	public List<Integer> getValidatedUserInput() {
		return validatedUserInput;
	}
}
