package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;


public class RandomGenerator {
    public static int getRandomNumber(int length) {
        Set<Integer> randomNumberSet = getRandomNumberSet(length);
        return makeNumber(randomNumberSet);
    }

    private static int makeNumber(Set<Integer> set) {
        int number = 0;
        for (Integer value : set) {
            number *= 10;
            number += value;
        }
        return number;
    }

    private static Set<Integer> getRandomNumberSet(int length) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!set.contains(randomNumber)) {
                set.add(randomNumber);
            }
        }
        return set;
    }
}
