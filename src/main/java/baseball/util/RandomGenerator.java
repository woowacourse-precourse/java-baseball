package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomGenerator {

    private static Integer genNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static List<Integer> genNumberList(int n) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < n) {
            set.add(genNumber());
        }

        return new ArrayList<>(set);
    }
}
