package baseball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallTest {

    Ball computerBall;

    @BeforeEach
    public void setUp() {
        computerBall = Ball.of(1, 1);
    }

    @Test
    public void 공_생성_테스트() {
        Ball userBall = Ball.of(1, 1);
        assertThat(userBall).isEqualTo(computerBall);
    }

    @Test
    public void 매개변수_범위_검증() {
        assertThatThrownBy(
            () -> Ball.of(0, 1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
            () -> Ball.of(10, 1)
        ).isInstanceOf(IllegalArgumentException.class);

        assertDoesNotThrow(() -> Ball.of(1, 1));
    }

    @Test
    public void 공_타입_NOTHING_테스트() {
        Ball userBall = Ball.of(2, 2);
        BallType type = userBall.play(computerBall);

        assertThat(type).isEqualTo(BallType.NOTHING);
    }

    @Test
    public void 공_타입_BALL_테스트() {
        Ball userBall = Ball.of(1, 2);
        BallType type = userBall.play(computerBall);

        assertThat(type).isEqualTo(BallType.BALL);
    }

    @Test
    public void 공_타입_STRIKE_테스트() {
        Ball userBall = Ball.of(1, 1);
        BallType type = userBall.play(computerBall);

        assertThat(type).isEqualTo(BallType.STRIKE);
    }

}
