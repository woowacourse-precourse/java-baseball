package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RandomGenerator {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
