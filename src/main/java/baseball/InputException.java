package baseball;

import java.util.HashSet;

public class InputException {
    public static boolean checkLength(String number) {
        return number.length() == Constant.NUMBER_LENGTH;
    }

    public static boolean isAllNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(String number) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            hashSet.add(number.charAt(i));
        }

        return hashSet.size() == Constant.NUMBER_LENGTH;
    }
}
