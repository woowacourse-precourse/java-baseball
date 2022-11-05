package baseball;

import java.util.HashSet;

public class InputException {
    private static boolean checkLength(String number) {
        return number.length() == Constant.NUMBER_LENGTH;
    }

    private static boolean isAllNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(String number) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            hashSet.add(number.charAt(i));
        }
        return hashSet.size() == Constant.NUMBER_LENGTH;
    }

    private static boolean isInZero(String number) {
        return !number.contains("0");
    }

    public static void occur(String number) {
        if (!(checkLength(number) && isAllNumber(number) && isDuplicate(number) && isInZero(number))){
            throw new IllegalArgumentException();
        }
    }
}
