package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.ScoreCalculator.BallOrStrike;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

    @Test
    void calScoreCase1() {
        EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 3, 2));
        EnumMap<BallOrStrike, Integer> expected = new EnumMap<>(Map.of(BallOrStrike.BALL, 2, BallOrStrike.STRIKE, 1));

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void calScoreCase2() {
        EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 2, 4));
        EnumMap<BallOrStrike, Integer> expected = new EnumMap<>(Map.of(BallOrStrike.BALL, 0, BallOrStrike.STRIKE, 2));

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void calScoreCase3() {
        EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(3, 1, 2));
        EnumMap<BallOrStrike, Integer> expected = new EnumMap<>(Map.of(BallOrStrike.BALL, 3, BallOrStrike.STRIKE, 0));

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void calScoreCase4() {
        EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 2, 3));
        EnumMap<BallOrStrike, Integer> expected = new EnumMap<>(Map.of(BallOrStrike.BALL, 0, BallOrStrike.STRIKE, 3));

        assertThat(score).isEqualTo(expected);
    }

    @Test
    void calScoreCase5() {
        EnumMap<BallOrStrike, Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(4, 5, 6));
        EnumMap<BallOrStrike, Integer> expected = new EnumMap<>(Map.of(BallOrStrike.BALL, 0, BallOrStrike.STRIKE, 0));

        assertThat(score).isEqualTo(expected);
    }

}