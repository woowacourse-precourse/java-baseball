package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

	private static final int MIN_LIST_INDEX = 0;
	private static final int MAX_LIST_INDEX = 3;

	private static final String PATTERN_ON_PLAYING = "^[1-9]{3}?$";
	private static final String PATTERN_ON_RESTARTING = "^[1-2]?$";

	private static final String STATUS_PLAYING = "PLAYING";
	private static final String STATUS_TERMINATING = "TERMINATING";

	public String userInput;
	public String patternedUserInput;
	private List<Integer> validatedUserInput;

	User() {
	}

	private void scanInput() {
		userInput = Console.readLine();
	}

	public void patternValidateInput() {
		if (!Pattern.matches(PATTERN_ON_PLAYING, userInput)) {
			throw new IllegalArgumentException();
		}
		patternedUserInput = userInput;
	}

	public void duplicationValidateInput() {
		validatedUserInput = new ArrayList<>();

		for (int index = MIN_LIST_INDEX; index < MAX_LIST_INDEX; index++) {
			if (validatedUserInput.contains(Character.getNumericValue(patternedUserInput.charAt(index)))) {
				throw new IllegalArgumentException();
			}
			validatedUserInput.add(Character.getNumericValue(patternedUserInput.charAt(index)));
		}
	}

	private void scanInputWhenPlaying() {
		scanInput();
		patternValidateInput();
		duplicationValidateInput();
	}

	public void answerValidateInput() {
		if (!Pattern.matches(PATTERN_ON_RESTARTING, userInput)) {
			throw new IllegalArgumentException();
		}
		validatedUserInput = new ArrayList<>();
		validatedUserInput.add(Integer.parseInt(userInput));
	}

	private void scanInputWhenTerminating() {
		scanInput();
		answerValidateInput();
	}

	public void scanInputByStatus(String nowStatus) {
		if (nowStatus.equals(STATUS_PLAYING)) {
			scanInputWhenPlaying();
		}
		if (nowStatus.equals(STATUS_TERMINATING)) {
			scanInputWhenTerminating();
		}
	}

	public List<Integer> getValidatedUserInput() {
		return validatedUserInput;
	}
}
