package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void 스트라이크_판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(1, 3);
        assertThat(ball.isStrike(otherBall)).isTrue();
    }
}
