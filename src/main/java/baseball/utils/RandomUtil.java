package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int[] createRandomNumberList() {
        int[] randomNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = createRandomNumber();
        }
        return createRandomNumberList();
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
