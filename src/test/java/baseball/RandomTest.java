package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RandomTest extends NsTest {
    @Test
    void ThrowTheBallTest() {
        // given
        int ballNumberLength = 3;
        Computer computer = new Computer();

        // when
        computer.throwTheBall();

        // then

        assertThat(computer.getBallNumber().stream().distinct().count())
                .isEqualTo(ballNumberLength);
    }

    @Override
    protected void runMain() {

    }
}
