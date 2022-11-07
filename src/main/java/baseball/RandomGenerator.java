package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomGenerator {
    public static List<Integer> makeNotDuplicatedRandomNumbers(int numberCnt, int minRange, int maxRange) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < numberCnt) {
            numbers.add(Randoms.pickNumberInRange(minRange, maxRange));
        }
        return new ArrayList<>(numbers);
    }
}
