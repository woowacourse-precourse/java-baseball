package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberBaseball {
    private static int getRandomThreeDigitNumber() {
        List<Integer> possible = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int ret = 0;

        for (int chooseCount = 0; chooseCount < 3; chooseCount++) {
            int randomNumber = Randoms.pickNumberInRange(0, (8 - chooseCount));
            ret *= 10;
            ret += possible.remove(randomNumber);
        }
        return ret;
    }
    private boolean isCorrectNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!('1' <= number.charAt(i) && number.charAt(i) <= '9')) {
                return false;
            }
        }
        if (number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2)
                || number.charAt(0) == number.charAt(2)) {
            return false;
        }
        return true;
    }
}
