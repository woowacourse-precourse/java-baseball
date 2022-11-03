package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void nothing() {
        Ball computer = new Ball(2, 5);
        assertThat(computer.play(new Ball(3, 6))).isEqualTo(BallStatus.NOTHING);
    }
}
