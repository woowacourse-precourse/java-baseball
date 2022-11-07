package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.util.BaseballConst.MAX_BALL_COUNT;

public class RandomNumberGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    public static List<Integer> generate() {
        return Stream.generate(() -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))
                .distinct()
                .limit(MAX_BALL_COUNT)
                .collect(Collectors.toList());
    }
}
