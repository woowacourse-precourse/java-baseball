package game.util;

public class Validate {
    public static void InputNumbers(String input) throws IllegalArgumentException {
        isLengthThree(input);
        isAllNumbers(input);
        isContainZero(input);
        isDifferent(input);
    }

    private static void isDifferent(String str) throws IllegalArgumentException {
        for (int i = 0; i < str.length(); ++i) {
            isOnlyOne(str, i);
        }
    }

    private static void isOnlyOne(String str, int index) throws IllegalArgumentException {
        if (str.indexOf(str.charAt(index)) != str.lastIndexOf(str.charAt(index))) {
            throw new IllegalArgumentException();
        }
    }

    private static void isContainZero(String str) throws IllegalArgumentException {
        for (int i = 0; i < str.length(); ++i) {
            isZero(str.charAt(i));
        }
    }

    private static void isZero(char ch) throws IllegalArgumentException {
        if (ch == '0') {
            throw new IllegalArgumentException();
        }
    }

    private static void isAllNumbers(String str) throws IllegalArgumentException {
        for (int i = 0; i < str.length(); ++i) {
            isNumber(str.charAt(i));
        }
    }

    private static void isNumber(char ch) throws IllegalArgumentException {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isLengthThree(String str) throws IllegalArgumentException {
        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static int isOneOrTwo(String str) throws IllegalArgumentException {
        if (str.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (toNumber(str) != 1 && toNumber(str) != 2) {
            throw new IllegalArgumentException();
        }
        return toNumber(str);
    }

    private static int toNumber(String str) throws IllegalArgumentException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
