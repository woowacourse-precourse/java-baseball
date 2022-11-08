package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static String randomNum() {
        String num = "";
        for (int i = 0; i < Constant.MAX_LENGTH; i++) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (num.contains(String.valueOf(random))) {
                i--;
                continue;
            }
            num += random;
        }
        return num;
    }
}
