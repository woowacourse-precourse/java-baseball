package baseball.computer;

public class Validator {

    public static boolean isInteger(String n) {
        try {
            int nu = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidInteger(Integer n) {
        return 99 < n && n < 1000;
    }
}
