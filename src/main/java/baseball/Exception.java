package baseball;

public class Exception {

	public static void sameLetterError() {
		throw new IllegalArgumentException(View.SAME_LETTER_ERROR_MESSAGE);
	}

	public static void endOrRestartError() {
		throw new IllegalArgumentException(View.END_OR_RESTART_INPUT_ERROR_MESSAGE);
	}

	public static void lengthError() {
		throw new IllegalArgumentException(View.LENGTH_ERROR_MESSAGE);
	}

	public static void numberOnlyError() {
		throw new IllegalArgumentException(View.NUMBER_ONLY_ERROR_MESSAGE);
	}

	public static void numberRangeError() {
		throw new IllegalArgumentException(View.NUMBER_RANGE_ERROR_MESSAGE);
	}
}
