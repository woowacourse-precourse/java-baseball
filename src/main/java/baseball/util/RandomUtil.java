package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static String randomSizeThree() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3)
                .toString();
    }
}
