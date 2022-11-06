package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condition {
	static Application application = new Application();

	public static List<Integer> userNumbersException(String userNumbers) throws IllegalArgumentException {

		List<Integer> userNumbersList = new ArrayList<>();
		int userNumbersInt = Integer.parseInt(userNumbers);
		final Pattern userNumberPattern = Pattern.compile("^[1-9]*$");
		final Matcher matchUserNumber = userNumberPattern.matcher(userNumbers);
		final boolean isUserNumberMatch = matchUserNumber.find();
		char[] charUserNumbers = new char[userNumbers.length()];

		if (!isUserNumberMatch) {
			throw new IllegalArgumentException();
		}
		if (userNumbers.length() != 3) {
			throw new IllegalArgumentException();
		}
		for (int userNums = 0; userNums < userNumbers.length(); userNums++) {
			charUserNumbers[userNums] = userNumbers.charAt(userNums);
			char[] userNumberChar = userNumbers.toCharArray();
			userNumbersList.add((int) userNumberChar[userNums] - 48);
			if (userNums != userNumbers.indexOf(userNumbers.charAt(userNums))) {
				throw new IllegalArgumentException();
			}
		}
		return userNumbersList;
	}

	public static void continuedExceptionProcess(String continued) throws IllegalArgumentException {

		if (continued.equals("1")) {
			application.gameStart(application.getComputerNumbers());
		} else if (continued.equals("2")) {
			application.gameSet = false;
		} else {
			throw new IllegalArgumentException();
		}
	}
}