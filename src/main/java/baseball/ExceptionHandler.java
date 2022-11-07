package baseball;

public class ExceptionHandler {

	public static final String NOT_MATCHING_DIGITS = "입력된 숫자가 3자리가 아닙니다.";
	public static final String EXISTENCE_ZERO = "입력된 세자리 숫자 중 0이 존재합니다.";
	public static final String DUPLICATE_NUMBER = "입력된 세자리 숫자 중 중복된 숫자가 존재합니다.";

	public static void notMatchDigits() {
		throwIllegalArgumentExceptionWithMessage(NOT_MATCHING_DIGITS);
	}

	public static void existenceZero() {
		throwIllegalArgumentExceptionWithMessage(EXISTENCE_ZERO);
	}

	public static void duplicateNumber() {
		throwIllegalArgumentExceptionWithMessage(DUPLICATE_NUMBER);
	}

	private static void throwIllegalArgumentExceptionWithMessage(String message) {
		throw new IllegalArgumentException(message);
	}

}
