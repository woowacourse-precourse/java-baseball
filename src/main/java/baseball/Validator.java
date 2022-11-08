package baseball;

public class Validator {
	private static boolean isDecimalNumber(String userInput) {
		int len = userInput.length();
		int index = 0;

		while (index < len && Character.isDigit(userInput.charAt(index)))
			index++;
		return (index == len);
	}

	private static boolean isThreeDigits(String userInput) {
		int userNumber = Integer.parseInt(userInput);

		return (111 < userNumber && userNumber < 999);
	}

	private static boolean isAllUnique(String userInput) {
		char first = userInput.charAt(0);
		char second = userInput.charAt(1);
		char third = userInput.charAt(2);

		return (first != second && second != third && third != first);
	}

	public static void doNumberValidation(String userInput) {
		if (!isDecimalNumber(userInput))
			throw (new IllegalArgumentException("0 ~ 9 이외의 문자는 허용되지 않습니다."));
		if (!isThreeDigits(userInput))
			throw (new IllegalArgumentException("입력은 세 자리 십진수여야 합니다."));
		if (!isAllUnique(userInput))
			throw (new IllegalArgumentException("입력의 각 자릿값은 서로 달라야 합니다."));
	}
}
