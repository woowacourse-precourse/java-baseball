package error;

public class Examine {
    public static String hasDifferentNumbers(String str) throws IllegalArgumentException {
        isLengthThree(str);
        isAllNumbers(str);
        isContainZero(str);
        isDifferent(str);

        return str;
    }

    private static void isDifferent(String str) {
        for (int i = 0; i < str.length(); ++i) {
            isOnlyOne(str, i);
        }
    }

    private static void isOnlyOne(String str, int index) {
        if (str.indexOf(str.charAt(index)) != str.lastIndexOf(str.charAt(index))) {
            throw new IllegalArgumentException();
        }
    }

    private static void isContainZero(String str) {
        for (int i = 0; i < str.length(); ++i) {
            isZero(str.charAt(i));
        }
    }

    private static void isZero(char ch) {
        if (ch == '0') {
            throw new IllegalArgumentException();
        }
    }

    private static void isAllNumbers(String str) {
        for (int i = 0; i < str.length(); ++i) {
            isNumber(str.charAt(i));
        }
    }

    private static void isNumber(char ch) {
		if (!Character.isDigit(ch)) {
			throw new IllegalArgumentException();
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
