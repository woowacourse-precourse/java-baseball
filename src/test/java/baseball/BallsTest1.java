package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest1 {
    Balls computer;

    @BeforeEach
    void init() {
        computer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        assertThat(computer.play(new Ball(0, 4))).isEqualTo(BallStatus.NOTHING);
        assertThat(computer.play(new Ball(3, 9))).isEqualTo(BallStatus.NOTHING);
        assertThat(computer.play(new Ball(1, 7))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(computer.play(new Ball(0, 2))).isEqualTo(BallStatus.BALL);
        assertThat(computer.play(new Ball(3, 3))).isEqualTo(BallStatus.BALL);
        assertThat(computer.play(new Ball(1, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(computer.play(new Ball(0, 1))).isEqualTo(BallStatus.STRIKE);
        assertThat(computer.play(new Ball(1, 2))).isEqualTo(BallStatus.STRIKE);
        assertThat(computer.play(new Ball(2, 3))).isEqualTo(BallStatus.STRIKE);
    }
}
