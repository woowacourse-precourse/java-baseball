package error;

public class Examine {
	public static void hasDifferentNumbers(String str) throws IllegalArgumentException {
		isLengthThree(str);
		isAllNumbers(str);
		isContainZero(str);
		isDifferent(str);
	}

	private static void isDifferent(String str) {
		for (int i = 0; i < str.length(); ++i) {
			if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void isContainZero(String str) {
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '0') {
				throw new IllegalArgumentException();
			}
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

	public static int isOneOrTwo(String str) {
		if (str.length() != 1) {
			throw new IllegalArgumentException();
		}
		if (toNumber(str) != 1 && toNumber(str) != 2) {
			throw new IllegalArgumentException();
		}
		return toNumber(str);
	}

	private static int toNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
