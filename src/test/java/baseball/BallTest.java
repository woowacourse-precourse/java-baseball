package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 볼의_숫자가_10이면_예외발생() {
        assertThatThrownBy(() -> new Ball(1, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼의 숫자는 1~9까지만 가능합니다.");
    }

    @Test
    void 두개의_볼_비교하여_스트라이크_반환() {
        Ball ball = new Ball(1, 2);
        Ball otherBall = new Ball(1, 2);
        assertThat(ball.play(otherBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 두개의_볼_비교하여_볼_반환() {
        Ball ball = new Ball(1, 2);
        Ball otherBall = new Ball(2, 2);
        assertThat(ball.play(otherBall)).isEqualTo(BallStatus.BALL);
    }
}
