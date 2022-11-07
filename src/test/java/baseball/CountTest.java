package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    void countBall() {
        Count count = new Count();
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(2, 3, 4);

        count.countBall(computer, user);

        assertThat(count.ball).isEqualTo(2);
    }

    @Test
    void countStrike() {
        Count count = new Count();
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(2, 5, 3);

        count.countBall(computer, user);
        count.countStrike(computer, user);

        assertThat(count.ball).isEqualTo(1);
        assertThat(count.strike).isEqualTo(1);
    }

    @Test
    void printCount() {
    }

    @Test
    void restartOrExit() {
    }
}