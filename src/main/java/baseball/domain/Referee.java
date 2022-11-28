package baseball.domain;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

import java.util.stream.Stream;

public final class Referee {
    private Referee() {
    }

    public static Score makeScore(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return new Score(
                makeBallCount(baseballNum1, baseballNum2),
                makeStrikeCount(baseballNum1, baseballNum2)
        );
    }

    private static int makeBallCount(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(SystemConstant.GAME_DIGIT)
                .filter(i -> baseballNum2.contains(baseballNum1.getNumberAt(i)))
                .filter(i -> baseballNum1.getNumberAt(i) != baseballNum2.getNumberAt(i))
                .count();
    }

    private static int makeStrikeCount(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(SystemConstant.GAME_DIGIT)
                .filter(i -> baseballNum1.getNumberAt(i) == baseballNum2.getNumberAt(i))
                .count();
    }
}
