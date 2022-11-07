package baseball;

public class Exception {
    public static boolean isRedundancy(String number) {
        if (number.length() > 1 && number.charAt(0) == number.charAt(1)) {
            return true;
        }
        if (number.length() > 2 && number.charAt(0) == number.charAt(2)) {
            return true;
        }
        if (number.length() > 2 && number.charAt(1) == number.charAt(2)) {
            return true;
        }
        return false;
    }
    public static boolean isNumber(String number) {
        if (number.matches("[0-9]+"))
            return true;
        return false;
    }
    public static boolean isThreeNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        return true;
    }
}
