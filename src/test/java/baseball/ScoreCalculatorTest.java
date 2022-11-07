package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

    @Test
    void calScoreCase1() {
        List<Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 3, 2));

        assertThat(score).isEqualTo(List.of(2, 1));
    }

    @Test
    void calScoreCase2() {
        List<Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 2, 4));

        assertThat(score).isEqualTo(List.of(0, 2));
    }

    @Test
    void calScoreCase3() {
        List<Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(3, 1, 2));

        assertThat(score).isEqualTo(List.of(3, 0));
    }

    @Test
    void calScoreCase4() {
        List<Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(1, 2, 3));

        assertThat(score).isEqualTo(List.of(0, 3));
    }

    @Test
    void calScoreCase5() {
        List<Integer> score = ScoreCalculator.calScore(List.of(1, 2, 3), List.of(4, 5, 6));

        assertThat(score).isEqualTo(List.of(0, 0));
    }

}