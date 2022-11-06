package baseball;

import baseball.utils.Util;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public final class RandomNumGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private RandomNumGenerator() {
    }

    private static int makeRandomDigit() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static int makeDistinctRandomNumWithSize(int sizeLimit) {
        List<Integer> resultList = new ArrayList<>();
        int size;
        do {
            int randomDigit = makeRandomDigit();
            resultList.add(randomDigit);
            size = Util.getDistinctCountInIntegerList(resultList);
        } while (size < sizeLimit);
        return Util.mergeDistinctIntegerInList(resultList);
    }
}
