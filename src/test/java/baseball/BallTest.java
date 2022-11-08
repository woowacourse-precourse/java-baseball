package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    Ball computer;

    @BeforeEach
    void init() {
        computer = new Ball(2, 5);
    }

    @Test
    void nothing() {
        assertThat(computer.play(new Ball(3, 6))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(computer.play(new Ball(1, 5))).isEqualTo(BallStatus.BALL);
        assertThat(computer.play(new Ball(3, 5))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(computer.play(new Ball(2, 5))).isEqualTo(BallStatus.STRIKE);
    }
}
