package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {
    public int makeNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public List<Integer> makeThreeDifferentNumberListInRange(int min, int max) {
        Set<Integer> numberList = new HashSet<>();
        while (numberList.size() < 3) {
            numberList.add(makeNumberInRange(min, max));
        }
        return new ArrayList<>(numberList);
    }
}
