package baseball;

import baseball.baseball.Digits;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Random {

    public static List<Integer> pickUniqueNumbersInRange(
        final int startInclusive,
        final int endInclusive,
        final int count
    ) {
        Set<Integer> selectedSet = new HashSet<>();
        List<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int number;

            do {
                number = Randoms.pickNumberInRange(startInclusive, endInclusive);
            } while(selectedSet.contains(number));

            selectedSet.add(number);
            randomList.add(number);
        }

        return randomList;
    }
}
