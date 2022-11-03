package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomGenerator {
    public RandomGenerator() {
    }

    private Integer genNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<Integer> genNumberList(int n) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < n) {
            set.add(this.genNumber());
        }

        return new ArrayList<>(set);
    }
}
