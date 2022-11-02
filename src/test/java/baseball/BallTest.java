package baseball;

import baseball.domain.Ball;
import baseball.domain.BallType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    Ball computerBall;

    @BeforeEach
    public void setUp() {
        computerBall = new Ball(1, 1);
    }

    @Test
    public void 공_생성_테스트() throws Exception {

        Ball userBall = Ball.of(1,1);

        assertThat(userBall).isEqualTo(new Ball(1, 1));
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
