package baseball;

import static baseball.GameRules.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserInputValidator {
	public void isValidUserInput(String userInput){
		if(!isConsistNumber(userInput)){
			throw new IllegalArgumentException("입력값은 숫자로만 이루어져야합니다.");
		}

		if (!isDigitNumber(userInput)){
			throw new IllegalArgumentException(DIGIT_NUMBER.getCode() + "개의 수를 입력해야합니다.");
		}

		if (!isDifferentNumber(userInput)) {
			throw new IllegalArgumentException("서로다른 수를 입력해아합니다.");
		}

	}

	public void isValidProgressNumber(String userInput){
		if (!isConsistNumber(userInput)) {
			throw new IllegalArgumentException("입력값은 숫자로만 이루어져야합니다.");
		}

		if (isDisallowNumber(userInput)) {
			throw new IllegalArgumentException(
				"게임 재시작(" + GAME_RESTART.getCode() + ") 또는 " + "게임종료(" + GAME_END.getCode() + ") 만 입력가능합니다.");
		}

	}

	public boolean isConsistNumber(String userInput){
		final Pattern pattern = Pattern.compile("^[1-9]*?");
		return pattern.matcher(userInput).matches();
	}

	public boolean isDigitNumber(String userInput){
		return DIGIT_NUMBER.getCode().equals(userInput.length());
	}

	public boolean isDifferentNumber(String userInput){
		String[] userInputArray = userInput.split("");

		List<Integer> userNumbersList = Arrays.stream(userInputArray)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return userNumbersList.size() == userNumbersList.stream().distinct().count();
	}

	public boolean isDisallowNumber(String userInput){
		int UserNumber = Integer.parseInt(userInput);
		return !GAME_RESTART.getCode().equals(UserNumber) && !GAME_END.getCode().equals(UserNumber);
	}
}
