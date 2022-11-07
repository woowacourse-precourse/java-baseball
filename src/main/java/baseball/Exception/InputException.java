package baseball.Exception;

import java.util.HashSet;

public class InputException {

    public static boolean isValidInput(String number) {
        if (number.length() != 3) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
            if(c == '0') {
                return false;
            }
            if(!set.isEmpty() && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static boolean isValidRestartInput(String number) {
        if (number.equals("1") || number.equals("2")) {
            return true;
        }
        return false;
    }
}
