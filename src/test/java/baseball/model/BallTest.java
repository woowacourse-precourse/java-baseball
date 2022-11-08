package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    Ball ball;
    String result = "1볼 ";

    @BeforeEach
    void init() {
        ball = new Ball();
    }

    @Test
    void 볼() {
        assertThat(ball.getScore()).isEqualTo(0);

        ball.count();
        assertThat(ball.getScore()).isEqualTo(1);
    }

    @Test
    void 결과_아웃인경우() {
        assertThat(ball.result()).isEqualTo("");
    }

    @Test
    void 결과_볼인경우() {
        ball.count();
        assertThat(ball.result()).isEqualTo(result);
    }
}

