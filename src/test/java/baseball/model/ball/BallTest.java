package baseball.model.ball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void have_same_ball_number_is_same() {
        Ball ball = new Ball(new BallNumber(3));
        assertThat(new Ball(new BallNumber(3))).isEqualTo(ball);

        assertThat(new Ball(new BallNumber(4))).isNotEqualTo(ball);
    }
}
