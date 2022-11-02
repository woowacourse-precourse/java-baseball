package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {
    @Test
    void calculate_메서드로_볼과_스트라이크_개수를_계산() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 2);

        List<Integer> ballAndStrike = ResultCalculator.calculateBallAndStrike(computer, player);
        Integer ball = ballAndStrike.get(0);
        Integer strike = ballAndStrike.get(1);

        assertThat(ball).isEqualTo(2);
        assertThat(strike).isEqualTo(1);
    }
}
