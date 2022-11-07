package baseball.core.opponent;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    public static List<Integer> generate() {
        Stream.generate(() -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))
                .distinct()
                .limit(COUNT)
        return threeNumbers;
    }
}
