package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @Test
    void 스트라이크_판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(1, 3);
        assertThat(ball.isStrike(otherBall)).isTrue();
    }

    @Test
    void 볼_판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 3);
        assertThat(ball.isBall(otherBall)).isTrue();
    }

    @Test
    void 낫싱_판단() {
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 4);
        assertThat(ball.isNothing(otherBall)).isTrue();
    }

    @Test
    void 볼의_숫자가_0이면_예외발생() {
        assertThatThrownBy(() -> new Ball(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼의 숫자는 1~9까지만 가능합니다.");
    }
}
