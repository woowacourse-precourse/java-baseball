package baseball.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static List<Integer> createRandomNumbers(int digit, int minNumber, int maxNumber) {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < digit) {
            numberSet.add(Randoms.pickNumberInRange(minNumber, maxNumber));
        }

        return new ArrayList<>(numberSet);
    }

}