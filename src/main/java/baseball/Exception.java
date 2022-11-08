package baseball;

public class Exception {
    public static boolean isValidLength(String input) {
        if (input.length() != Computer.NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public static boolean isValidRange(String input) {
        char startRange = Character.forDigit(Computer.START_RANGE, 10);
        char endRange = Character.forDigit(Computer.END_RANGE, 10);
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur < startRange || cur > endRange) {
                return false;
            }
        }
        return true;
    }
}
