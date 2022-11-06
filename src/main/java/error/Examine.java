package error;

public class Examine {
	public static void hasDifferentNumbers(String str) {
		try {
			isLengthThree(str);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	private static void isLengthThree(String str) {
		if (str.length() != 3) {
			throw new IllegalArgumentException();
		}
	}
}
