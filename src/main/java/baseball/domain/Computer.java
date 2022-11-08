package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private final List<Integer> result;

    public Computer(int start, int end, int count) {
        result = initResult(start, end, count);
    }

    private static List<Integer> initResult(int start, int end, int count) {
        Set<Integer> baseballNumberSet = new HashSet<>();
        while (baseballNumberSet.size() < count) {
            baseballNumberSet.add(Randoms.pickNumberInRange(start, end));
        }
        return new ArrayList<>(baseballNumberSet);
    }

    public List<Integer> getResult() {
        return result;
    }
}
