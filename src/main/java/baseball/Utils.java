package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    private static List<Integer> pickUniqueNumbersInRange(final int startInclusive,
                                                          final int endInclusive,
                                                          final int count) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            set.add(pickNumber);
        }
        return new ArrayList<>(set);
    }

    public static Number pickComputerNumber() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 9, 3);
        return new Number(numbers);
    }
}
