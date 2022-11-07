package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RandomGenerator {

    private static final int NUMBERS_SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    public List<Integer> pickNumbers() {
        LinkedHashSet<Integer> computer = new LinkedHashSet<>();
        while (computer.size() < NUMBERS_SIZE) {
            computer.add(pickInRange());
        }
        return new ArrayList<>(computer);
    }

    protected int pickInRange() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
