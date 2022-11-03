package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    Balls computer;

    @BeforeEach
    void init() {
        computer = new Balls(Arrays.asList(
                new Ball(0, 1),
                new Ball(1, 2),
                new Ball(2, 3)));
    }

    @Test
    void nothing() {
        assertThat(computer.play(new Ball(0, 4))).isEqualTo(BallStatus.NOTHING);
        assertThat(computer.play(new Ball(3, 9))).isEqualTo(BallStatus.NOTHING);
        assertThat(computer.play(new Ball(1, 7))).isEqualTo(BallStatus.NOTHING);
    }
}
