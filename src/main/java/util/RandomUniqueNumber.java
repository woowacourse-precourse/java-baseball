package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomUniqueNumber {
    private static final int MINIMUM_RANDOM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 9;

    public static List<Integer> getRandomUniqueNumbers(int size) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER_RANGE, MAXIMUM_RANDOM_NUMBER_RANGE);

            if (!set.contains(randomNumber)) {
                set.add(randomNumber);
            }
        }

        return new ArrayList<>(set);
    }
}
