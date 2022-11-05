package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumGenerator {
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 9;

    public static int makeRandomDigitWithRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
