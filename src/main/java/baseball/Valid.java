package baseball;

public class Valid {

	private static final int DIGIT_LENGTH = 3;
	private static final String RESTART = "1";
	private static final String DO_NOT_RESTART = "2";
	private static final String EXCEPTION_MESSAGE = "값을 잘못 입력했습니다. 게임을 종료합니다.";

	public static String validInputNumber(String inputNumber) {
		if (isWrongLength(inputNumber) && isNaturalNumber(inputNumber) &&
			findDuplicate(inputNumber)) {
			return inputNumber;
		}

		throw new IllegalArgumentException(EXCEPTION_MESSAGE);
	}

	public static String validRestartNumber(String inputNumber) {
		if (isOneOrTwo(inputNumber)) {
			return inputNumber;
		}

		throw new IllegalArgumentException(EXCEPTION_MESSAGE);
	}

	private static boolean isWrongLength(String inputNumber) {
		if (inputNumber.length() == DIGIT_LENGTH) {
			return true;
		}
		return false;
	}

	private static boolean isNaturalNumber(String inputNumber) {
		for (int digitIndex = 0; digitIndex < inputNumber.length(); digitIndex++) {
			int digit = inputNumber.charAt(digitIndex) - '0';
			if (!(digit > 0 && digit < 10)) {
				return false;
			}
		}
		return true;
	}

	private static boolean findDuplicate(String inputNumber) {
		int firstNumber = inputNumber.charAt(0);
		int secondNumber = inputNumber.charAt(1);
		int thirdNumber = inputNumber.charAt(2);

		if (firstNumber == secondNumber ||
			secondNumber == thirdNumber ||
			firstNumber == thirdNumber) {
			return false;
		}
		return true;
	}

	private static boolean isOneOrTwo(String inputNumber) {
		if (inputNumber.equals(RESTART) || inputNumber.equals(DO_NOT_RESTART)) {
			return true;
		}
		return false;
	}
}