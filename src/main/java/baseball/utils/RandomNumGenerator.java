package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class RandomNumGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private RandomNumGenerator() {
    }

    public static int makeDistinctRandomNumWithSize(int sizeLimit) {
        List<Integer> splitRandomNums = new ArrayList<>();
        int size;
        do {
            int randomDigit = makeRandomDigit();
            splitRandomNums.add(randomDigit);
            size = ListUtility.getDistinctCountInIntegerList(splitRandomNums);
        } while (size < sizeLimit);
        return ListUtility.mergeDistinctIntegerInList(splitRandomNums);
    }

    private static int makeRandomDigit() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
