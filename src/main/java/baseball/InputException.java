package baseball;

import java.util.HashSet;

public class InputException {
    private static boolean checkLength(String number) {
        return number.length() == Constant.NUMBER_LENGTH;
    }

    private static boolean isAllNumber(String number) {
        // 사용자가 입력한 값이 모두 숫자인지 확인하는 메소드
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

    public static boolean occur(String number) {
        if (!(checkLength(number) && isAllNumber(number) && isDuplicate(number) && isInZero(number))){
            throw new IllegalArgumentException();
        }
        return false;
    }
}
