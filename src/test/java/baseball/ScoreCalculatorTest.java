package baseball;

import baseball.game.utils.ScoreBoard;
import baseball.game.utils.ScoreCalculator;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCalculatorTest {

    @Test
    void calculator_strike_테스트() {
        List<Integer> targetNumbers = Arrays.asList(1, 2, 3);
        List<Integer> attackNumbers = Arrays.asList(1, 2, 3);

        ScoreBoard scoreBoard = ScoreCalculator.calculate(targetNumbers, attackNumbers);

        Assertions.assertThat(scoreBoard.getBallAndStrike()).isEqualTo(Arrays.asList(0, 3));
    }

    @Test
    void calculator_ball_테스트() {
        List<Integer> targetNumbers = Arrays.asList(1, 2, 3);
        List<Integer> attackNumbers = Arrays.asList(3, 1, 2);

        ScoreBoard scoreBoard = ScoreCalculator.calculate(targetNumbers, attackNumbers);

        Assertions.assertThat(scoreBoard.getBallAndStrike()).isEqualTo(Arrays.asList(3, 0));
    }
}

