package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
	private static final int MIN_PATTERN_VALUE_ON_PLAYING = 1;
	private static final int MAX_PATTERN_VALUE_ON_PLAYING = 9;
	private static final int MAX_NUMBERS_COUNT = 3;
	private static final int MIN_PATTERN_VALUE_ON_RESTARTING = 1;
	private static final int MAX_PATTERN_VALUE_ON_RESTARTING = 2;
	private static final int MIN_LIST_SIZE = 0;
	private static final int MIN_LIST_INDEX = 0;
	private static final int MAX_LIST_INDEX = 3;

	private static final String PATTERN_ON_PLAYING =	"^[" + MIN_PATTERN_VALUE_ON_PLAYING +
														"-" + MAX_PATTERN_VALUE_ON_PLAYING +
														"]{" + MAX_NUMBERS_COUNT + "}$?";
	private static final String PATTERN_ON_RESTARTING =	"^[" + MIN_PATTERN_VALUE_ON_RESTARTING +
														"-" + MAX_PATTERN_VALUE_ON_RESTARTING + "]$?";

	private static final String STATUS_PLAYING = "PLAYING";
	private static final String STATUS_TERMINATING = "TERMINATING";

	public String userInput;
	public String patternedUserInput;
	private List<Integer> validatedUserInput;

	private Status status = new Status();

	User() {}

	private void scanInput() {
		userInput = Console.readLine();
	}

	public void patternValidateInput() {
		if(!Pattern.matches("^[1-9]{3}?$", userInput)) {
			throw new IllegalArgumentException();
		}
		patternedUserInput = userInput;
	}

	public void duplicationValidateInput() {
		validatedUserInput = new ArrayList<>();

		for(int i = 0; i < 3; i++) {
			if(validatedUserInput.contains(Character.getNumericValue(patternedUserInput.charAt(i)))) {
				throw new IllegalArgumentException();
			}
			validatedUserInput.add(Character.getNumericValue(patternedUserInput.charAt(i)));
		}
	}

	private void scanInputWhenPlaying() {
		scanInput();
		patternValidateInput();
		duplicationValidateInput();
	}

	public void answerValidateInput() {
		if(!Pattern.matches("^[1-2]?$", userInput)) {
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
		if(nowStatus.equals("PLAYING")) {
			scanInputWhenPlaying();
		}
		if(nowStatus.equals("TERMINATING")) {
			scanInputWhenTerminating();
		}
	}

	public List<Integer> getValidatedUserInput() {
		return validatedUserInput;
	}
}
