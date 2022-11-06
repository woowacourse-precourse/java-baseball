package baseball;

public class Exception {

	public static void numberOnlyException() {
		throw new IllegalArgumentException(View.NUMBER_ONLY_ERROR_MESSAGE);
	}

	public static void lengthException() {
		throw new IllegalArgumentException(View.LENGTH_ERROR_MESSAGE);
	}

	public static void endOrRestartException() {
		throw new IllegalArgumentException(View.END_OR_RESTART_INPUT_ERROR_MESSAGE);
	}

	public static void numberRangeException() {
		throw new IllegalArgumentException(View.NUMBER_RANGE_ERROR_MESSAGE);
	}

	public static void sameLetterException() {
		throw new IllegalArgumentException(View.SAME_LETTER_ERROR_MESSAGE);
	}
}
