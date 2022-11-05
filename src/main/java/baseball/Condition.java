package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Condition {
	static Application application = new Application();

	public static List<Integer> userNumbersException(String userNumbers) throws IllegalArgumentException {
		List<Integer> userNumbersList = new ArrayList<>();
		int userNumbersInt = 0;
		final Pattern userNumberPattern = Pattern.compile("^[1-9]*$");
		Matcher matchUserNumber = userNumberPattern.matcher(userNumbers);
		boolean isUserNumberMatch = matchUserNumber.find();
		if (!isUserNumberMatch)
			throw new IllegalArgumentException();
		if (userNumbers.length() != 3)
			throw new IllegalArgumentException();
		char[] charUserNumbers = new char[userNumbers.length()];
		for (int userNums = 0; userNums < userNumbers.length(); userNums++) {
			charUserNumbers[userNums] = userNumbers.charAt(userNums);
		}
		for (int charNumbers = 0; charNumbers < charUserNumbers.length; charNumbers++) {
			if (charNumbers != userNumbers.indexOf(userNumbers.charAt(charNumbers)))
				throw new IllegalArgumentException();
		}
		userNumbersInt = Integer.parseInt(userNumbers);
		for (int number = 0; number < userNumbers.length(); number++) {
			char[] userNumberChar = userNumbers.toCharArray();
			userNumbersList.add((int) userNumberChar[number] - 48);
		}
		return userNumbersList;
	}

	public static void continuedExceptionProcess(String continued) throws IllegalArgumentException {
		if (continued.equals("1"))
			application.gameStart(application.getComputerNumbers());
		else if (continued.equals("2"))
			application.gameSet = false;
		else
			throw new IllegalArgumentException();
	}
}
