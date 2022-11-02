package baseball.domain;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballFactory {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int GENERATE_BALL_COUNT = 3;

    public static List<Baseball> generate() {
        List<Integer> baseballs = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, GENERATE_BALL_COUNT);

        return baseballs.stream()
                .map(Baseball::new)
                .collect(toList());
    }
}
