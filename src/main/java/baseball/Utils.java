package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Utils {

    public static List<Integer> intToList(int input) {
        List<Integer> returnList = new ArrayList<>();

        while (input > 0) {
            returnList.add(input % 10);
            input /= 10;
        }

        Collections.reverse(returnList);
        return returnList;
    }

    public static boolean isValidUserAnswerInput(String s) {
        // 자리수 확인
        if (s.length() != Constants.NUM_LENGTH) {
            return false;
        }

        // 서로 다른 숫자이어야 한다.
        boolean[] duplicateCheck = new boolean[10];
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num < 0 || duplicateCheck[num]) {
                return false;
            }
            duplicateCheck[num] = true;
        }

        // 0은 허용되지 않는다.
        if (duplicateCheck[0]) {
            return false;
        }

        return true;
    }
}
