package baseball.util;

import static baseball.domain.Ball.MAX_BALL_NUMBER;
import static baseball.domain.Ball.MIN_BALL_NUMBER;
import static baseball.domain.Balls.BALLS_FORMAL_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumbers {

    public static List<Integer> createRandomNumbers() {
        return Stream.generate(() -> Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER))
                .distinct()
                .limit(BALLS_FORMAL_SIZE)
                .collect(Collectors.toUnmodifiableList());
    }
}
