package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Play {
    private static final int COUNT = 3;
    /**
     * Enforce class non-instantiability with private constructor.
     */
    private Play() {
        throw new AssertionError();
    }

    static int getCount() {
        return COUNT;
    }

    static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < COUNT) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(digit)) {
                randomNumber.add(digit);
            }
        }
        return randomNumber;
    }
}
