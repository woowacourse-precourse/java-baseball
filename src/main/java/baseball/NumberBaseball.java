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
}
