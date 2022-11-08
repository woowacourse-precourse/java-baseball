package baseball;

public class Exception {

    public static boolean isException(String number) {
        if (isNumber(number)) {
            return true;
        }
        if (isThreeNumber(number)) {
            return true;
        }
        if (isRedundancy(number)) {
            return true;
        }
        return false;
    }

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
        if (number.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
    public static boolean isThreeNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        return true;
    }

    public static int validateCheckPoint(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("입력값은 1 또는 2만 가능합니다.");
        }
        return Integer.parseInt(number);
    }
}
