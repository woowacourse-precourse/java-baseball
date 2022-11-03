package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    @DisplayName("strike 인 공이 존재")
    void strike() {
        Balls balls = new Balls("123");
        assertThat(balls.compareOneBallInOrder(new Ball(1, 2))).isEqualTo(BallStatus.STRIKE);
    }
}
