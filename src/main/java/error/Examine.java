package error;

public class Examine {
	public static void hasDifferentNumbers(String str) {
		try {
			isLengthThree(str);
			isAllNumbers(str);
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	private static void isAllNumbers(String str) {
		for (int i = 0; i < str.length(); ++i) {
			if (!Character.isDigit(str.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void isLengthThree(String str) {
		if (str.length() != 3) {
			throw new IllegalArgumentException();
		}
	}
}
