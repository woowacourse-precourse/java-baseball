package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CountTest extends NsTest {

    @Test
    void countBall() {
        Count count = new Count();
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(2, 3, 4);

        count.countBall(computer, user);

        assertThat(count.getBall()).isEqualTo(2);
    }

    @Test
    void countStrike() {
        Count count = new Count();
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(2, 5, 3);

        count.countBall(computer, user);
        count.countStrike(computer, user);

        assertThat(count.getBall()).isEqualTo(1);
        assertThat(count.getStrike()).isEqualTo(1);
    }

    @Test
    void printCount() {
    }

    @Test
    void restartOrExit() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Count.restartOrExit();
    }
}