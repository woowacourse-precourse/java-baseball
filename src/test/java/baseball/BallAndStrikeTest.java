package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallAndStrikeTest {
    @Test
    void from_메서드로_볼과_스트라이크_개수를_계산() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 2);

        BallAndStrike ballAndStrike = BallAndStrike.from(computer, player);
        int ball = ballAndStrike.getBall();
        int strike = ballAndStrike.getStrike();

        assertThat(ball).isEqualTo(2);
        assertThat(strike).isEqualTo(1);
    }
}
