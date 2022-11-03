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
}
