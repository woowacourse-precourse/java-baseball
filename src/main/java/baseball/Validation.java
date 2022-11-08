package baseball;

public class Validation {
    public static boolean isInputError(String input) {
        return (input.length() != 3) || hasNonDigit(input) || hasSameNumber(input);
    }

    public static boolean hasNonDigit(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasSameNumber(String input) {
        char c1 = input.charAt(0);
        char c2 = input.charAt(1);
        char c3 = input.charAt(2);

        return (c1 == c2) || (c1 == c3) || (c2 == c3);
    }

    public static boolean isEndInputError(String input) {
        if (input.equals("1") || input.equals("2")) {
            return false;
        }
        return true;
    }
}
