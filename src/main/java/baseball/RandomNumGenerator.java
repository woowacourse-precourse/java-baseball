package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private RandomNumGenerator() {
    }

    private static int makeRandomDigit() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
    public static int makeRandomNumWithNDigits(int digits) {
        int result = 0;
        while (--digits >= 0) {
            result += makeRandomDigit() * Math.pow(10, digits);
        }
        return result;
    }
}
