package baseball.domain;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

import java.util.stream.Stream;

public final class ScoreCalculator {
    private ScoreCalculator() {
    }

    public static Score calculateUserFinalScore(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return new Score(
                calculateBallCount(baseballNum1, baseballNum2),
                calculateStrikeCount(baseballNum1, baseballNum2)
        );
    }

    private static int calculateBallCount(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(SystemConstant.GAME_DIGIT)
                .filter(i -> baseballNum2.contains(baseballNum1.getNumberAt(i)))
                .filter(i -> baseballNum1.getNumberAt(i) != baseballNum2.getNumberAt(i))
                .count();
    }

    private static int calculateStrikeCount(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(SystemConstant.GAME_DIGIT)
                .filter(i -> baseballNum1.getNumberAt(i) == baseballNum2.getNumberAt(i))
                .count();
    }
}
