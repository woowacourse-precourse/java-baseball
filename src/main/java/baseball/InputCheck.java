package baseball;

public class InputCheck {

    public static boolean isInputError(String input) {
        char temp;

        if (input.length() != 3) {
            return true;
        }
        if (hasNonDigit(input)) {
            return true;
        }
        if (hasSameNumber(input)) {
            return true;
        }
        return false;
    }

    public static boolean hasNonDigit(String input) {
        char temp;

        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (!Character.isDigit(temp)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSameNumber(String input) {
        char c1 = input.charAt(0);
        char c2 = input.charAt(1);
        char c3 = input.charAt(2);

        if ((c1 == c2) || (c1 == c3)) {
            return true;
        }
        if (c2 == c3) {
            return true;
        }
        return false;
    }

    public static boolean isEndInputError(String input) {
        if (input.equals("1") || input.equals("2")) {
            return false;
        }
        return true;
    }
}
