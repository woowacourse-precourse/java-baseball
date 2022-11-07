package baseball.Exception;

import java.util.HashSet;

public class InputException {

    public static boolean isValidInput(String number) {
        if (number.length() != 3) {
            return false;
        }
        if (!isDigits(number)) {
            return false;
        }
        if (containZero(number)) {
            return false;
        }
        if (isDuplicate(number)) {
            return false;
        }
        return true;
    }

    public static boolean isDigits(String number) {
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containZero(String number) {
        for (char c: number.toCharArray()) {
            if (c == '0') {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicate(String number) {
        HashSet<Character> set = new HashSet<Character>();
        for (char c : number.toCharArray()) {
            if(!set.isEmpty() && set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    public static boolean isValidRestartInput(String number) {
        if (number.equals("1") || number.equals("2")) {
            return true;
        }
        return false;
    }
}
