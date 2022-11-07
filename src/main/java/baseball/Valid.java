package baseball;

public class Valid {
	private static final int DIGIT_LENGTH = 3;
	private static final String EXCEPTION_MESSAGE = "값을 잘못 입력했습니다. 게임을 종료합니다.";

	public static String validInputNumber(String inputNumber) {
		if (validAnswerLength(inputNumber)) {
			return inputNumber;
		}

		throw new IllegalArgumentException(EXCEPTION_MESSAGE);
	}

	public static boolean validAnswerLength(String input) {
		if (input.length() == DIGIT_LENGTH) {
			return true;
		}
		return false;
	}

}
