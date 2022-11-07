package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BallTest {

    @Test
    void generateNumber_서로다른_숫자3개_리턴() {
        Ball ball = new Ball();

        assertThat(ball.getNumber()).hasSize(3);
    }


}