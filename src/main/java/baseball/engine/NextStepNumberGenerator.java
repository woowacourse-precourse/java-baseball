package baseball.engine;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextStepNumberGenerator implements NumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    @Override
    public Numbers generate(int size) {
        return new Numbers(
                Stream.generate(() -> Randoms.pickNumberInRange(START_RANGE, END_RANGE))
                        .distinct()
                        .limit(size)
                        .collect(Collectors.toList())
        );
    }
}
