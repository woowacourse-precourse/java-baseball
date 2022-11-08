package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static String generateNumber() {
        StringBuilder resultString = new StringBuilder();

        while (resultString.length() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!resultString.toString().contains(String.valueOf(randomDigit))) {
                resultString.append(randomDigit);
            }
        }
        return resultString.toString();
    }
}
